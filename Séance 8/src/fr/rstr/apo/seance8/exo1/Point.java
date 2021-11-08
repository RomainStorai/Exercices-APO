package fr.rstr.apo.seance8.exo1;

import javafx.geometry.Point2D;

public abstract class Point {

    private Point2D centre;

    public Point(Point2D centre) {
        this.centre = centre;
    }

    public Point2D getCentre() {
        return centre;
    }

    public void setCentre(Point2D centre) {
        this.centre = centre;
    }
}
