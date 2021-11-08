package fr.rstr.apo.seance8.exo1;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Forme> formes = new ArrayList<>();
        formes.add(new Cercle(new Point2D(10d, 7.65), 5d));
        formes.add(new Rectangle(new Point2D(0d, 0d), 10d, 15d));
        formes.add(new Carre(new Point2D(10d, 10d), 30d));

        formes.forEach(System.out::println);
    }
}
