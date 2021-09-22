package fr.rstr.seance2.exo2;

public class Rect {

    private final int numRectangle;
    private final Point p1, p2;

    // Compteur de rectangle, ne dépend pas d'un objet.
    private static int numActuel = 1;

    public Rect(int x1, int x2, int y1, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);

        // On lui attribue un numéro
        this.numRectangle = numActuel;
        numActuel++;
    }

    /*
     * ====================
     *      Méthodes
     * ====================
     */

    /**
     * Permet de récupérer la surface du rectangle
     *
     * @return int Surface du rectange
     */
    public int surface() {
        int longueur = Math.max(p1.getAbscisse(), p2.getAbscisse()) - Math.min(p1.getAbscisse(), p2.getAbscisse());
        int largeur = Math.max(p1.getOrdonnee(), p2.getOrdonnee()) - Math.min(p1.getOrdonnee(), p2.getOrdonnee());
        return longueur * largeur;
    }

    @Override
    public String toString() {
        return "R" + numRectangle + " (" + p1 + ", " + p2 + ')';
    }
}
