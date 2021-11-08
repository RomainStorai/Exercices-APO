package fr.rstr.apo.seance8.exo1;

import javafx.geometry.Point2D;

public abstract class Forme extends Point {

    public Forme(Point2D centre) {
        super(centre);
    }

    @Override
    public String toString() {
        return "Forme -- " + this.getClass().getSimpleName() + ", centre (" + getCentre().getX() + ", " + getCentre().getY() + ")";
    }
}
