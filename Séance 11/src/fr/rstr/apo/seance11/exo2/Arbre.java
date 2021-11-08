package fr.rstr.apo.seance11.exo2;

public class Arbre<Element> {

    private final Element element;
    private final Arbre<Element> filsG;
    private final Arbre<Element> filsD;

    public Arbre() {
        element = null;
        filsG = null;
        filsD = null;
    }

    public Arbre(Arbre<Element> filsG, Element element, Arbre<Element> filsD) {
        this.element = element;
        this.filsG = filsG;
        this.filsD = filsD;
    }

    public Arbre<Element> filsGauche() {
        if (estVide())
            return this;
        return filsG;
    }

    public Arbre<Element> filsDroit() {
        if (estVide())
            return this;
        return filsD;
    }

    public Element racine() throws Exception {
        if (element == null)
            throw new Exception();
        return element;
    }

    public boolean estVide() {
        return element == null;
    }

    @Override
    public String toString() {
        if (estVide())
            return "Arbre vide";
        return "[" + filsG + "; " + element + "; " + filsD + "]";
    }
}
