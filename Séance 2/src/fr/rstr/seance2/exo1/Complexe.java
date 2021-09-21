package fr.rstr.seance2.exo1;

public class Complexe {

    private final double reelle, imaginaire;

    public Complexe(double reelle, double imaginaire) {
        this.reelle = reelle;
        this.imaginaire = imaginaire;
    }

    /*
     * ====================
     *      Méthodes
     * ====================
     */

    @Override
    public String toString() {
        return (reelle != 0 ? reelle : "") + (reelle != 0 && imaginaire != 0 ? "+" : "") + (imaginaire != 0 ? imaginaire + "*i" : "") + (reelle == 0 && imaginaire == 0 ? "0" : "");
    }

    /**
     * Crée un nouveau complexe en additionnant ce complexe avec un autre (complexe 2)
     *
     * @param complexe Complexe 2
     * @return Complexe calculé
     */
    public Complexe ajout(Complexe complexe) {
        return new Complexe(reelle + complexe.reelle, imaginaire + complexe.imaginaire);
    }

    /**
     * Crée un nouveau complexe en multipliant ce complexe avec un autre (complexe 2)
     *
     * @param complexe Complexe 2
     * @return Complexe calculé
     */
    public Complexe multiplie(Complexe complexe) {
        double a = reelle, b = imaginaire, a_prime = complexe.reelle, b_prime = complexe.imaginaire;
        return new Complexe(a * a_prime - b * b_prime, a * b_prime + a_prime * b);
    }
}
