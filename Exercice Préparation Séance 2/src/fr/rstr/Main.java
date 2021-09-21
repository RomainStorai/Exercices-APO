package fr.rstr;

public class Main {

    public static void main(String[] args) {
        Etudiant a = new Etudiant("Storaï", "Romain", "FIG172");
        Etudiant b = new Etudiant("Sardi", "Manon", "FIG172");
        Etudiant c = new Etudiant("Peira", "Dylan", "INFRES");

        a.direBonjour();
        b.direBonjourA(a);
        c.direBonjourA(b);
    }

}
