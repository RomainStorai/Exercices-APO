package fr.rstr.apo.seance8.exo1;

import javafx.geometry.Point2D;

public class Cercle extends Forme implements Surface {

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

    public double getPerimetre() {
        return Math.PI * diametre;
    }

    public double getSurface() {
        return Math.PI * Math.pow(diametre / 2, 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", diamètre " + diametre;
    }
}
