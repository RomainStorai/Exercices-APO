package fr.rstr;

public class Etudiant {

    private final String nom, prenom, promo;

    public Etudiant(String nom, String prenom, String promo) {
        this.nom = nom;
        this.prenom = prenom;
        this.promo = promo;
    }

    /* ====================
     *      Méthodes
     * ====================
     */

    /**
     * Fait dire bonjour à l'étudiant actuel
     */
    public void direBonjour() {
        System.out.printf("Bonjour je m'appelle %s %s, je suis de la promo %s%n", prenom, nom, promo);
    }

    /**
     * Fait dire bonjour à l'étudiant 2
     * @param etudiant Etudiant 2
     */
    public void direBonjourA(Etudiant etudiant) {
        if (etudiant.promo.equals(promo))
            System.out.printf("Salut %s, je m’appelle %s%n", etudiant.prenom, prenom);
        else
            direBonjour();
    }

}
