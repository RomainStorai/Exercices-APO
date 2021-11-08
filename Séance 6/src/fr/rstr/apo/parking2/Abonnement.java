package fr.rstr.apo.parking2;

public class Abonnement {

    private final Parking parking;
    private final Vehicule vehicule;
    private int date;
    private boolean present;

    public Abonnement(Parking parking, Vehicule vehicule, int date) {
        this.parking = parking;
        this.vehicule = vehicule;
        this.date = date;

        vehicule.setAbonnement(this);
    }

    /**
     * Récupérer le parking associé
     *
     * @return Parking
     */
    public Parking getParking() {
        return parking;
    }

    /**
     * Récupérer le véhicule
     *
     * @return Véhicule
     */
    public Vehicule getVehicule() {
        return vehicule;
    }

    /**
     * Récupérer la date de validité
     *
     * @return date
     */
    public int getDate() {
        return date;
    }

    /**
     * Savoir si le véhicule est présent actuellement dans le parking
     *
     * @return boolean true si présent false sinon
     */
    public boolean estPresent() {
        return present;
    }

    /**
     * Mettre à jour la présence du véhicule dans le parking
     *
     * @param present true si présent
     */
    public void setPresent(boolean present) {
        this.present = present;
    }

    /**
     * Mettre à jour la date d'expiration de l'abonnement
     *
     * @param date d'expiration
     */
    public void prolonger(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "vehicule=" + vehicule +
                ", date=" + date +
                ", present=" + present +
                '}';
    }
}
