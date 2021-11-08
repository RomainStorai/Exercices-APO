package fr.rstr.apo.seance8.exo2;

public class SegmentTrain {

    private final String reference;
    private Train assignation;
    private double poidVide, poidMax, longueur, charge = 0;

    public SegmentTrain(String reference, double poidVide, double poidMax, double longueur) {
        this.reference = reference;
        this.poidVide = poidVide;
        this.poidMax = poidMax;
        this.longueur = longueur;
    }

    public String getReference() {
        return reference;
    }

    public double getPoidVide() {
        return poidVide;
    }

    protected void setPoidVide(double poidVide) {
        this.poidVide = poidVide;
    }

    public double getPoidMax() {
        return poidMax;
    }

    public Train getAssignation() {
        return assignation;
    }

    public void setAssignation(Train assignation) {
        this.assignation = assignation;
    }

    protected void setPoidMax(double poidMax) {
        this.poidMax = poidMax;
    }

    public double getLongueur() {
        return longueur;
    }

    protected void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getCharge() {
        return charge;
    }

    protected void setCharge(double charge) {
        this.charge = charge;
    }
}
