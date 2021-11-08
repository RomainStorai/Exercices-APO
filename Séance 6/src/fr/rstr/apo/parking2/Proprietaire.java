package fr.rstr.apo.parking2;

import java.util.ArrayList;

public class Proprietaire {

    private final String nom;
    private final ArrayList<Vehicule> vehicules = new ArrayList<>();

    public Proprietaire(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer le nom du propriétaire
     *
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Ajouter un véhicule à la liste du proprio
     *
     * @param vehicule Véhicule
     */
    public void ajouter(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    /**
     * Retirer un véhicule de la liste de ceux du proprio
     *
     * @param immatriculation String
     */
    public void retirer(String immatriculation) {
        vehicules.removeIf(vehicule -> vehicule.getImmatriculation().equalsIgnoreCase(immatriculation));
    }

    /**
     * Récupérer un véhicule par son immatriculation
     *
     * @param immatriculation à chercher
     * @return Véhicule trouvé
     */
    public Vehicule get(String immatriculation) {
        return vehicules.stream().filter(vehicule -> vehicule.getImmatriculation().equalsIgnoreCase(immatriculation)).findFirst().orElse(null);
    }

    /**
     * Lister toutes les voitures d'un proprio
     */
    public void lister() {
        vehicules.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Proprietaire " + nom;
    }
}
