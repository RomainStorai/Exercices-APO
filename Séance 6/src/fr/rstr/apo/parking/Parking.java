package fr.rstr.apo.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Parking {

    private final UUID id = UUID.randomUUID();
    private final int capaciteMaximale;
    private int jourActuel = 0;

    private final List<Barriere> barrieres = new ArrayList<>();

    private final List<Abonnement> abonnements = new ArrayList<>();
    private final List<Vehicule> vehicules = new ArrayList<>();

    public Parking(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    /**
     * Récupérer l'identifiant du parking
     *
     * @return UUID identifiant
     */
    public UUID getId() {
        return id;
    }

    /**
     * Récupérer la capacité maximale du parking (nombre de places)
     *
     * @return int nombre total de places
     */
    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    /**
     * Permet de récupérer le nombre de places restantes en prenant en compte les abonnements
     *
     * @return nombre de places
     */
    public int getPlacesRestantes() {
        return capaciteMaximale - abonnements.size();
    }

    /**
     * Donne le jour actuel du parking
     *
     * @return jour
     */
    public int getJourActuel() {
        return jourActuel;
    }

    /**
     * Retourne la liste des barrières du parking
     *
     * @return liste des barrières
     */
    public List<Barriere> getBarrieres() {
        return barrieres;
    }

    /**
     * Récupérer les abonnements actuels (non périmés sauf si le véhicule est encore garé)
     *
     * @return liste des abonnements
     */
    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    /**
     * Récupérer tous les abonnements d'un propriétaire
     *
     * @param proprietaire Propriétaire
     * @return liste des abonnements
     */
    public List<Abonnement> getAbonnementsDuProprietaire(UUID proprietaire) {
        return abonnements.stream().filter(abonnement -> abonnement.getProprietaire().equals(proprietaire)).toList();
    }

    /**
     * Récupérer l'abonnement associé à un véhicule
     *
     * @param immatriculation du véhicule
     * @return Abonnement
     */
    public Optional<Abonnement> getAbonnementDeVoiture(String immatriculation) {
        return abonnements.stream().filter(abonnement -> abonnement.getVoiture().equalsIgnoreCase(immatriculation)).findFirst();
    }

    /**
     * Récupérer la liste des véhicules garés actuellement dans le parking
     *
     * @return liste des véhicules
     */
    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    /**
     * Savoir si le véhicule avec une immatriculation est présent dans le parking
     *
     * @param immatriculation du véhicule
     * @return boolean
     */
    public boolean contientVehicule(String immatriculation) {
        return vehicules.stream().anyMatch(vehicule -> vehicule.getImmatriculation().equalsIgnoreCase(immatriculation));
    }

    /**
     * Ajouter un véhicule au parking
     *
     * @param vehicule à ajouter
     */
    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    /**
     * Supprimer un véhicule du parking
     *
     * @param vehicule à supprimer
     */
    public void supprimerVehicule(Vehicule vehicule) {
        vehicules.remove(vehicule);
    }

    /**
     * Permet d'effectuer un nouveau jour, et de supprimer tous les abonnements plus valides (dont les voitures sont absentes)
     */
    public void nouveauJour() {
        jourActuel++;
        List<Abonnement> aSupprimer = abonnements.stream().filter(a -> a.getDernierJour() < jourActuel).toList();
        aSupprimer.forEach(a -> supprimerAbonnement(a.getVoiture()));
    }

    /**
     * Ajouter une barrière au parking
     *
     * @param barriere à ajouter
     */
    public void ajouterBarriere(Barriere barriere) {
        barrieres.add(barriere);
    }

    /**
     * Permet de supprimer une barrière grâce à son identifiant
     *
     * @param id identifiant de la barrière
     */
    public void supprimerBarriere(UUID id) {
        Optional<Barriere> barriere = barrieres.stream().filter(b -> b.getId().equals(id)).findFirst();
        barriere.ifPresent(barrieres::remove);
    }

    /**
     * Permet d'ajouter un abonnement s'il reste de la place.
     *
     * @param abonnement Abonnement à ajouter
     * @return true si l'abonnement a pu être ajouté
     */
    public boolean ajouterAbonnement(Abonnement abonnement) {
        if (getPlacesRestantes() > 0) {
            abonnements.add(abonnement);
            return true;
        }
        return false;
    }

    /**
     * Supprimer un abonnement si le véhicule n'est pas présent
     *
     * @param immatriculation de la voiture concernée par l'abonnement
     * @return true si l'abonnement a pu être supprimé
     */
    public boolean supprimerAbonnement(String immatriculation) {
        Optional<Abonnement> optionalAbonnement = abonnements.stream().filter(a -> a.getVoiture().equalsIgnoreCase(immatriculation)).findFirst();
        if (optionalAbonnement.isPresent())
            return supprimerAbonnement(optionalAbonnement.get());
        return false;
    }

    /**
     * Supprimer un abonnement si le véhicule n'est pas présent
     *
     * @param abonnement Abonnement à supprimer
     * @return true si l'abonnement a pu être supprimé
     */
    public boolean supprimerAbonnement(Abonnement abonnement) {
        if (contientVehicule(abonnement.getVoiture()))
            return false;
        abonnements.remove(abonnement);
        return true;
    }

    /**
     * Permet d'allonger l'abonnement d'une voiture
     *
     * @param immatriculation de la voiture concernée
     * @param joursEnPlus     à ajouter
     */
    public void prolongerAbonnement(String immatriculation, int joursEnPlus) {
        Optional<Abonnement> abonnement = abonnements.stream().filter(a -> a.getVoiture().equalsIgnoreCase(immatriculation)).findFirst();
        abonnement.ifPresent(a -> a.setDernierJour(a.getDernierJour() + joursEnPlus));
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", capaciteMaximale=" + capaciteMaximale +
                ", placesRestantes=" + getPlacesRestantes() +
                ", jourActuel=" + jourActuel +
                ", barrieres=" + barrieres + " (" + barrieres.size() + ")" +
                ", abonnements=" + abonnements + " (" + abonnements.size() + ")" +
                ", vehicules=" + vehicules + " (" + vehicules.size() + ")" +
                '}';
    }
}
