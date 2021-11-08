package fr.rstr.apo.seance8.exo2;

public class Voiture extends SegmentTrain {

    private final int numero, places;

    public Voiture(int numero, int places, String reference, double poidVide, double poidMax, double longueur) {
        super(reference, poidVide, poidMax, longueur);
        this.numero = numero;
        this.places = places;
    }

    public int getNumero() {
        return numero;
    }

    public int getPlaces() {
        return places;
    }
}
