package fr.rstr.apo.seance8;

import javafx.geometry.Point2D;

public class Cercle extends Forme {

    private double diametre;

    public Cercle(Point2D centre, double diametre) {
        super(centre);
        this.diametre = diametre;
    }

    public double getDiametre() {
        return diametre;
    }

    public void setDiametre(double diametre) {
        this.diametre = diametre;
    }

    @Override
    double getPerimetre() {
        return Math.PI * diametre;
    }

    @Override
    double getSurface() {
        return Math.PI * Math.pow(diametre / 2, 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", diamètre " + diametre;
    }
}
