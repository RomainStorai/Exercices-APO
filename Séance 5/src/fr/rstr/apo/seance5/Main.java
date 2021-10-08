package fr.rstr.apo.seance5;

public class Main {

    public static void main(String[] args) {
        // Création de 2 listes
        ListeDEntiers liste1 = new ListeDEntiers();
        ListeDEntiers liste2 = new ListeDEntiers();
        // Ajout aléatoire de valeurs
        liste1.ajouter(40, 20); // 40 entiers de valeur comprise entre 0 et 20
        liste2.ajouter(20, 15); // 20 entiers de valeur comprise entre 0 et 15
        // Comptage
        System.out.println(liste1.compter(7));
        // Affichage des listes
        System.out.println(liste1);
        System.out.println(liste2);
        // Suppression
        liste1.supprimer(12);
        System.out.println(liste1);
        // Affichage de la liste des valeurs communes
        System.out.println(liste1.valeursEnCommunAvec(liste2));
        System.out.println(liste2);
        // Dédoublonnage
        int n = liste1.dedoublonner();
        System.out.println(n);
        System.out.println(liste1);
    }

}
