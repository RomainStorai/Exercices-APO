package fr.rstr.apo.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingManager {

    public static final Map<UUID, Parking> parkings = new HashMap<>();
    private static final Map<UUID, Proprietaire> proprietaires = new HashMap<>();
    public static final Map<String, Vehicule> vehicules = new HashMap<>();

    /**
     * Permet d'ajouter un propriétaire de véhicule
     *
     * @param nom du propriétaire
     * @return l'instance de l'objet, notamment pour récupérer son identifiant
     */
    public static Proprietaire ajouterProprietaire(String nom) {
        Proprietaire proprietaire = new Proprietaire(nom);
        proprietaires.put(proprietaire.getId(), proprietaire);
        return proprietaire;
    }

    /**
     * Permet de récupérer un parking via son identifiant
     *
     * @param id identifiant du parking
     * @return parking
     */
    public static Parking getParking(UUID id) {
        return parkings.get(id);
    }

    /**
     * Permet de récupérer un propriétaire via son identifiant
     *
     * @param id identifiant du propriétaire
     * @return propriétaire
     */
    public static Proprietaire getProprietaire(UUID id) {
        return proprietaires.get(id);
    }

    /**
     * Permet de récupérer un véhicule via son identifiant
     *
     * @param id identifiant du véhicule
     * @return véhicule
     */
    public static Vehicule getVehicule(String id) {
        return vehicules.get(id);
    }
}
