package fr.rstr.apo.seance8;

import javafx.geometry.Point2D;

public class Carre extends Rectangle {

    public Carre(Point2D centre, double cote) {
        super(centre, cote, cote);
    }

    @Override
    public void setLargeur(double largeur) {
        super.setLargeur(largeur);
        setLongueur(largeur);
    }

    @Override
    public void setLongueur(double longueur) {
        super.setLongueur(longueur);
        setLargeur(longueur);
    }

    @Override
    public String toString() {
        return super.toString() + ", côté " + getLargeur();
    }
}
