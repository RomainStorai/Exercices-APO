package fr.rstr.apo.seance8.exo1;

import javafx.geometry.Point2D;

public class Rectangle extends Forme implements Surface {

    private double largeur, longueur;

    public Rectangle(Point2D centre, double largeur, double longueur) {
        super(centre);
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getSurface() {
        return largeur * longueur;
    }

    @Override
    public double getPerimetre() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", largeur " + largeur + ", longueur " + longueur;
    }
}
