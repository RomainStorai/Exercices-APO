package fr.rstr.apo.seance4;

import java.util.Scanner;

public class Main {

    static Etudiant[] promotion;

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        // Taille de la promotion
        System.out.println("Combien d'étudiants font parti de cette promotion ?");
        int nombreEtudiant = clavier.nextInt();
        promotion = new Etudiant[nombreEtudiant];

        // Saisie des étudiants
        String prenom, nom;
        for (int i = 0; i < nombreEtudiant; i++) {
            System.out.println("\nRenseignez les informations de l'étudiant " + (i+1));
            System.out.print("Prénom : ");
            prenom = clavier.next();
            System.out.print("Nom : ");
            nom = clavier.next();
            Etudiant etudiant = new Etudiant(prenom, nom);
            etudiant.ajouterLesNotes(clavier);
            promotion[i] = etudiant;
        }

        afficherPromotion();
        trierMoyenneDecroissantes(promotion);
        afficherPromotion();

        rechercherEtudiant(clavier);
    }

    /**
     * Permet de trier la promotion par moyenne décroissante
     * @param promo Etudiant[] promotion
     */
    public static void trierMoyenneDecroissantes(Etudiant[] promo) {
        int taille = promo.length;
        Etudiant tmp;
        for (int i = 0; i < taille; i++) {
            for (int j = 1; j < (taille - i); j++) {
                if (promo[j - 1].getMoyenne() < promo[j].getMoyenne()) {
                    tmp = promo[j - 1];
                    promo[j - 1] = promo[j];
                    promo[j] = tmp;
                }
            }
        }
    }

    /**
     * Afficher la promotion avec le détail des élèves
     */
    public static void afficherPromotion() {
        System.out.println("================ Promotion ================");
        for (Etudiant etudiant : promotion) {
            afficherEtudiant(etudiant);
        }
    }

    /**
     * Afficher les informations d'un étudiant
     * @param etudiant Etudiant à afficher
     */
    private static void afficherEtudiant(Etudiant etudiant) {
        System.out.println("Etudiant " + etudiant.getNum());
        System.out.printf("     Nom: %s %s%n", etudiant.getPrenom(), etudiant.getNom());
        System.out.printf("     %s Notes: ", etudiant.getNotes().length);
        for (double note : etudiant.getNotes())
            System.out.printf("%s ", note);
        System.out.printf("%n     Moyenne: %s", etudiant.getMoyenne());
        System.out.print("\n");
    }

    /**
     * Lancer la recherche d'un étudiant par rapport à son nom et son prénom
     * @param clavier Scanner
     */
    public static void rechercherEtudiant(Scanner clavier) {
        Etudiant trouve = null;
        while (trouve == null) {
            System.out.println("\nQuel étudiant recherchez vous ?");
            String recherche = clavier.next();
            for (Etudiant etudiant : promotion) {
                if (etudiant.getNom().equalsIgnoreCase(recherche) || etudiant.getPrenom().equalsIgnoreCase(recherche)) {
                    trouve = etudiant;
                    break;
                }
            }
            if (trouve == null)
                System.out.println("Etudiant introuvable... Essayez de renseigner son nom ou son prénom exact !");
        }

        afficherEtudiant(trouve);
    }
}
