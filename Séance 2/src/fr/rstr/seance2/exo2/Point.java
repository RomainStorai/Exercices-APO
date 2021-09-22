package fr.rstr.seance2.exo2;

public class Point {

    private final int abscisse, ordonnee;

    public Point(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    /**
     * Récupérer l'abscisse du point
     *
     * @return int abscisse
     */
    public int getAbscisse() {
        return abscisse;
    }

    /**
     * Récupérer l'ordonée du point
     *
     * @return int ordonée
     */
    public int getOrdonnee() {
        return ordonnee;
    }

    @Override
    public String toString() {
        return abscisse + ", " + ordonnee;
    }
}
