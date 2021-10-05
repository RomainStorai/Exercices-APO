package fr.rstr.apo.prepseance5;

public class Main {

    public static void main(String[] args) {
        // Création d’un étudiant : penser à initialiser sa liste de notes
        Etudiant a = new Etudiant("Jean-Paul", "Veuillez", 141);
        // Ajout de notes
        a.ajouterNote(18);
        a.ajouterNote(2);
        // Affichage de la liste de notes
        System.out.println(a.listeNotes());
        // Affichage de la moyenne
        System.out.println(a.moyenne());
    }
}
