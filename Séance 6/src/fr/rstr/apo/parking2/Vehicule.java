package fr.rstr.apo.parking2;

public class Vehicule {

    private final String immatriculation;
    private Proprietaire proprietaire;
    private Abonnement abonnement;

    public Vehicule(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
     * Récupérer l'abonnement associé à la voiture
     *
     * @return Abonnement
     */
    public Abonnement getAbonnement() {
        return abonnement;
    }

    /**
     * Récupérer le propriétaire du véhicule
     *
     * @return Propriétaire
     */
    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    /**
     * Récupérer l'immatriculation du véhicule
     *
     * @return String immat
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Mettre à jour l'abonnement du véhicule
     *
     * @param abonnement du véhicule
     */
    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    /**
     * Mettre à jour le propriétaire du véhicule
     *
     * @param proprietaire Proprio
     */
    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return "Véhicule " + immatriculation;
    }
}
