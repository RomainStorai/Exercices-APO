package fr.rstr;

public class Main {

    public static void main(String[] args) {
        Etudiant a = new Etudiant("Storaï", "Romain", "FIG172");
        Etudiant b = new Etudiant("Sardi", "Manon", "FIG172");
        Etudiant c = new Etudiant("Peira", "Dylan", "INFRES");

        a.direBonjour(); // Bonjour je m'appelle Romain Storaï, je suis de la promo FIG172
        b.direBonjourA(a); // Salut Romain, je m’appelle Manon
        c.direBonjourA(b); // Bonjour je m'appelle Dylan Peira, je suis de la promo INFRES
    }

}
