package fr.rstr.apo.seance8.exo2;

public class ElementAutomoteur extends SegmentTrain {

    private final int puissance, places;

    public ElementAutomoteur(int puissance, int places, String reference, double poidVide, double poidMax, double longueur) {
        super(reference, poidVide, poidMax, longueur);
        this.puissance = puissance;
        this.places = places;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getPlaces() {
        return places;
    }
}
