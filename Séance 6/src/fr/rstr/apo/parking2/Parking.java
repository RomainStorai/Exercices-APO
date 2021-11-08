package fr.rstr.apo.parking2;

import java.util.ArrayList;

public class Parking {

    private final int nbPlaces;
    private ArrayList<Abonnement> abonnements;
    private ArrayList<Barriere> barrieres;
    private int jour = 0;

    public Parking(int nbp) {
        this.nbPlaces = nbp;
    }

    /**
     * Mettre le jour actuel du Parking
     *
     * @param jour jour
     */
    public void setJour(int jour) {
        this.jour = jour;
    }

    /**
     * Récupérer la date du jour
     *
     * @return date
     */
    public int getJour() {
        return jour;
    }

    /**
     * Récupérer le nombre de places dans le parking
     *
     * @return places totales
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * Récupérer une barrière spécifique
     *
     * @param id id
     * @return barrière
     */
    public Barriere getBarriere(int id) {
        return barrieres.stream().filter(barriere -> barriere.getId() == id).findFirst().orElse(null);
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
     * Supprimer une barrière id
     *
     * @param id à supprimer
     */
    public void supprimerBarriere(int id) {
        barrieres.removeIf(barriere -> barriere.getId() == id);
    }

    /**
     * Lister toutes les barrières présentes
     */
    public void listerBarrieres() {
        barrieres.forEach(System.out::println);
    }

    /**
     * Mettre un état de service à une barrière spécifique
     *
     * @param id        id
     * @param enService état
     */
    public void setEnService(int id, boolean enService) {
        Barriere toChange = getBarriere(id);
        if (toChange != null)
            toChange.setEnService(enService);
    }

    /**
     * Récupérer l'abonnement d'une immatriculation
     *
     * @param immatriculation à chercher
     * @return abonnement
     */
    public Abonnement getAbonnement(String immatriculation) {
        return abonnements.stream().filter(abonnement -> abonnement.getVehicule().getImmatriculation().equalsIgnoreCase(immatriculation)).findFirst().orElse(null);
    }

    /**
     * Ajouter un abonnment (donc un véhicule) au parking
     *
     * @param vehicule concerné
     * @param date     de validité
     */
    public void ajouterAbonnement(Vehicule vehicule, int date) {
        abonnements.add(new Abonnement(this, vehicule, date));
    }

    /**
     * Supprimer un abonnement
     *
     * @param immatriculation à supprimer
     */
    public void supprimerAbonnement(String immatriculation) {
        abonnements.removeIf(abonnement -> abonnement.getVehicule().getImmatriculation().equalsIgnoreCase(immatriculation));
    }

    /**
     * Changer la date de validité d'un abonnement
     *
     * @param immatriculation à changer
     * @param date            nouvelle
     */
    public void prolonger(String immatriculation, int date) {
        abonnements.stream().filter(abonnement -> abonnement.getVehicule().getImmatriculation().equalsIgnoreCase(immatriculation)).forEach(abonnement -> abonnement.prolonger(date));
    }

    /**
     * Lister tous les abonnements
     */
    public void listerAbonnements() {
        abonnements.forEach(System.out::println);
    }

    /**
     * Lister tous les abonnements d'un propriétaire
     *
     * @param nom du proprio
     */
    public void listerAbonnements(String nom) {
        abonnements.stream().filter(abonnement -> abonnement.getVehicule().getProprietaire().getNom().equals(nom)).forEach(System.out::println);
    }

    /**
     * Lister les véhicules présents
     */
    public void listerPresents() {
        abonnements.stream().filter(Abonnement::estPresent).forEach(System.out::println);
    }

    /**
     * Récupérer le nombre de véhicules présents
     *
     * @return nombre de présents
     */
    public int nombrePresents() {
        return abonnements.stream().filter(Abonnement::estPresent).mapToInt(value -> 1).sum();
    }
}
