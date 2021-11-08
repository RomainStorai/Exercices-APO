package fr.rstr.apo.seance8;

import javafx.geometry.Point2D;

public abstract class Forme {

    private Point2D centre;

    public Forme(Point2D centre) {
        this.centre = centre;
    }

    public Point2D getCentre() {
        return centre;
    }

    public void setCentre(Point2D centre) {
        this.centre = centre;
    }

    abstract double getSurface();
    abstract double getPerimetre();

    @Override
    public String toString() {
        return "Forme -- " + this.getClass().getSimpleName() + ", centre (" + centre.getX() + ", " + centre.getY() + ")";
    }
}
