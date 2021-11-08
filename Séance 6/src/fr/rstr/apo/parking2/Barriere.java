package fr.rstr.apo.parking2;

public class Barriere {

    private static int compteur = 0;

    private final int id;
    private boolean enService = true;
    private final Parking parking;

    public Barriere(Parking parking) {
        this.parking = parking;
        this.id = compteur++;
    }

    /**
     * Mettre la barrière dans un certain service
     *
     * @param enService true si oui
     */
    public void setEnService(boolean enService) {
        this.enService = enService;
    }

    /**
     * Savoir si la barrière est en service
     *
     * @return état
     */
    public boolean estEnService() {
        return enService;
    }

    /**
     * Récupérer l'identifiant de la barrière
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Présenter une immatriculation à l'entrée
     *
     * @param immatriculation présentée
     */
    public void entrer(String immatriculation) {
        if (!enService) {
            System.out.println("Barrière hors service.");
            return;
        }

        if (parking.getNbPlaces() - parking.nombrePresents() >= 1) {
            Abonnement abonnement = parking.getAbonnement(immatriculation);
            if (abonnement == null || abonnement.getDate() < parking.getJour())
                System.out.println("L'abonnement n'est plus valide.");
            else if (abonnement.estPresent())
                System.out.println("La voiture est déjà dans le parking.");
            else {
                abonnement.setPresent(true);
                System.out.println("Vous êtes dans le parking.");
            }
        } else
            System.out.println("Il n'y a plus de places dans le parking.");
    }

    /**
     * Présenter une plaque à la sortie du parking
     *
     * @param immatriculation présentée
     */
    public void sortir(String immatriculation) {
        if (!enService) {
            System.out.println("Barrière hors service.");
            return;
        }

        Abonnement abonnement = parking.getAbonnement(immatriculation);
        if (abonnement == null)
            return;

        if (!abonnement.estPresent()) {
            System.out.println("La voiture n'est pas présente dans le parking...");
            return;
        }

        abonnement.setPresent(false);
        System.out.println("Aurevoir !");

        if (parking.getJour() < abonnement.getDate()) {
            parking.supprimerAbonnement(immatriculation);
            System.out.println("Votre abonnement, étant dépassé, a été supprimé.");
        }
    }

    @Override
    public String toString() {
        return "Barriere{" +
                "id=" + id +
                ", enService=" + enService +
                '}';
    }
}
