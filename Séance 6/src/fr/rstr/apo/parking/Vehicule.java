package fr.rstr.apo.parking;

import fr.rstr.apo.parking.ParkingManager;

import java.util.UUID;

public class Vehicule {

    private final String immatriculation;
    private final UUID proprietaire;

    public Vehicule(String immatriculation, UUID proprietaire) {
        this.immatriculation = immatriculation;
        this.proprietaire = proprietaire;
        ParkingManager.getProprietaire(proprietaire).ajouterVehicule(this);
    }

    /**
     * Récupérer l'immatriculation du véhicule
     *
     * @return String immatriculation
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Permet de savoir l'identifiant du propriétaire actuel
     *
     * @return UUID propriétaire
     */
    public UUID getProprietaire() {
        return proprietaire;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "immatriculation='" + immatriculation + '\'' +
                ", proprietaire=" + proprietaire +
                '}';
    }
}
