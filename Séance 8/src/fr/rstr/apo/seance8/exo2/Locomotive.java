package fr.rstr.apo.seance8.exo2;

public class Locomotive extends SegmentTrain {

    private final double puissance;

    public Locomotive(String reference, double poidVide, double poidMax, double longueur, double puissance) {
        super(reference, poidVide, poidMax, longueur);
        this.puissance = puissance;
    }

    public double getPuissance() {
        return puissance;
    }
}
