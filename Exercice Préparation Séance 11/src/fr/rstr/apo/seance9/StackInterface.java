package fr.rstr.apo.seance9;

public interface StackInterface<Element> {

    /**
     * Permet de retirer le premier élément du stack
     *
     * @return Stack sans le premier élément
     */
    public StackInterface<Element> pop();

    /**
     * Retourne le premier élément du stack
     *
     * @return Element premier
     */
    public Element top();

    /**
     * Récupérer la taille du stack
     *
     * @return int taille
     */
    public int size();

    /**
     * Savoir si le stack contient au moins un élément
     *
     * @return boolean true si il est vide
     */
    public boolean isEmpty();
}
