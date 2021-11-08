package fr.rstr.apo.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Proprietaire {

    private final UUID id = UUID.randomUUID();
    private final String nom;
    private final List<Vehicule> vehicules = new ArrayList<>();

    public Proprietaire(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer l'identifiant du propriétaire
     *
     * @return UUID
     */
    public UUID getId() {
        return id;
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
     * Permet de récupérer la liste des véhicules du propriétaire
     *
     * @return Liste de véhicules
     */
    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    /**
     * Ajouter un véhicule au propriétaire
     *
     * @param vehicule Véhicule à ajouter
     */
    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    /**
     * Supprime un véhicule de la circulation
     *
     * @param immatriculation du véhicule à supprimer
     */
    public void supprimerVehicule(String immatriculation) {
        Optional<Vehicule> optionalVehicule = vehicules.stream().filter(v -> v.getImmatriculation().equalsIgnoreCase(immatriculation)).findFirst();
        if (optionalVehicule.isEmpty())
            return;

        Vehicule vehicule = optionalVehicule.get();

        for (Parking parking : ParkingManager.parkings.values()) {
            parking.supprimerVehicule(vehicule);
            parking.supprimerAbonnement(vehicule.getImmatriculation());
        }
    }

    @Override
    public String toString() {
        return "Proprietaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", vehicules=" + vehicules +
                '}';
    }
}
