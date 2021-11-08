package fr.rstr.apo.parking;

import java.util.UUID;

public class Abonnement {

    private final String voiture;
    private final UUID parking, proprietaire;
    private int dernierJour;

    public Abonnement(String voiture, UUID parking, UUID proprietaire, int dernierJour) {
        this.voiture = voiture;
        this.parking = parking;
        this.proprietaire = proprietaire;
        this.dernierJour = dernierJour;
    }

    /**
     * Récupérer l'immatriculation de la voiture concernée par l'abonnement
     *
     * @return String immatriculation de la voiture
     */
    public String getVoiture() {
        return voiture;
    }

    /**
     * Récupérer le dernier jour de validité de l'abonnement
     *
     * @return int dernier jour
     */
    public int getDernierJour() {
        return dernierJour;
    }

    /**
     * Récupérer l'identifiant du parking relié à cet abonnement
     *
     * @return UUID identifiant du parking concerné
     */
    public UUID getParking() {
        return parking;
    }

    /**
     * Récupérer l'identifiant du propiétaire relié à cet abonnement
     *
     * @return UUID identifiant du propriétaire concerné
     */
    public UUID getProprietaire() {
        return proprietaire;
    }

    /**
     * Mettre à jour le dernier jour de validité de l'abonnement
     *
     * @param dernierJour Dernier jour de l'abonnement
     */
    public void setDernierJour(int dernierJour) {
        this.dernierJour = dernierJour;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "voiture='" + voiture + '\'' +
                ", dernierJour=" + dernierJour +
                '}';
    }
}
