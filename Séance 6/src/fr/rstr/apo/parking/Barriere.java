package fr.rstr.apo.parking;

import java.util.Optional;
import java.util.UUID;

public class Barriere {

    private final UUID id = UUID.randomUUID();
    private final UUID parking;
    private final TypeBarriere type;
    private EtatBarriere etat;

    public Barriere(UUID parking, TypeBarriere type) {
        this.parking = parking;
        this.type = type;
        this.etat = EtatBarriere.EN_SERVICE;
    }

    public Barriere(UUID parking, TypeBarriere type, EtatBarriere etat) {
        this.parking = parking;
        this.type = type;
        this.etat = etat;
    }

    /**
     * Récupérer l'identifiant de la barrière
     *
     * @return UUID identifiant unique
     */
    public UUID getId() {
        return id;
    }

    /**
     * Permet de récupérer le type de barrière (entrée ou sortie)
     *
     * @return TypeBarriere
     */
    public TypeBarriere getType() {
        return type;
    }

    /**
     * Permet de savoir si la barrière est en service ou momentanément hors service
     *
     * @return EtatBarriere
     */
    public EtatBarriere getEtat() {
        return etat;
    }

    /**
     * Récupérer l'identifiant du parking relié à cette barrière
     *
     * @return UUID identifiant du parking concerné
     */
    public UUID getParking() {
        return parking;
    }

    /**
     * Changer l'état de la barrière
     *
     * @param etat EtatBarriere souhaité
     */
    public void setEtat(EtatBarriere etat) {
        this.etat = etat;
    }

    /**
     * Appelée lors de l'arrivée d'un véhicule en face d'une barrière
     *
     * @param immatriculation lue par la barrière
     * @param reponse         Réponse de la barrière
     */
    public void detecteUnVehicule(String immatriculation, Reponse reponse) {
        if (etat == EtatBarriere.HORS_SERVICE)
            return;

        switch (type) {
            case ENTREE -> entreeDeVehicule(immatriculation, reponse);
            case SORTIE -> sortieDeVehicule(immatriculation, reponse);
        }
    }

    /**
     * Cette méthode gère l'entrée d'un véhicule
     *
     * @param immatriculation lue
     * @param reponse         Réponse de la barrière
     */
    private void entreeDeVehicule(String immatriculation, Reponse reponse) {
        Parking parking = ParkingManager.getParking(this.parking);
        Vehicule vehicule = ParkingManager.getVehicule(immatriculation.toLowerCase());
        Optional<Abonnement> optionalAbonnement = parking.getAbonnementDeVoiture(immatriculation);
        if (optionalAbonnement.isEmpty()) {
            reponse.echec("Aucun abonnement n'a été trouvé à cette immatriculation");
            return;
        }

        if (parking.contientVehicule(immatriculation)) {
            reponse.echec("Ce véhicule est déjà dans le parking");
            return;
        }

        reponse.reussite(false);
        parking.ajouterVehicule(vehicule);
    }

    /**
     * Cette méthode gère la sortie d'un véhicule
     *
     * @param immatriculation lue
     * @param reponse         Réponse de la barrière
     */
    private void sortieDeVehicule(String immatriculation, Reponse reponse) {
        Parking parking = ParkingManager.getParking(this.parking);
        Vehicule vehicule = ParkingManager.getVehicule(immatriculation.toLowerCase());
        Optional<Abonnement> optionalAbonnement = parking.getAbonnementDeVoiture(immatriculation);
        if (!parking.contientVehicule(immatriculation)) {
            reponse.echec("Véhicule non présent dans le parking");
            return;
        }

        if (optionalAbonnement.isPresent() && optionalAbonnement.get().getDernierJour() > parking.getJourActuel()) {
            reponse.reussite(true);
            parking.supprimerAbonnement(optionalAbonnement.get());
            parking.supprimerVehicule(vehicule);
            return;
        }

        reponse.reussite(false);
        parking.supprimerVehicule(vehicule);
    }

    @Override
    public String toString() {
        return "Barriere{" +
                "id=" + id +
                ", type=" + type +
                ", etat=" + etat +
                '}';
    }

    /**
     * Type de barrière
     */
    public enum TypeBarriere {
        ENTREE,
        SORTIE
    }

    /**
     * Etat de la barrière
     */
    public enum EtatBarriere {
        EN_SERVICE,
        HORS_SERVICE
    }
}
