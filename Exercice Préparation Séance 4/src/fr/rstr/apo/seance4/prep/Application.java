package fr.rstr.apo.seance4.prep;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        // Création du tableau de la taille demandée
        System.out.println("Quelle est la taille de ce tableau ?");
        int tailleTab = clavier.nextInt();
        int[] tableau = new int[tailleTab];

        // On récupère les valeurs
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Valeur de la case " + (i + 1));
            tableau[i] = clavier.nextInt();
        }

        afficherTableau(tableau);
        System.out.printf("Maximum : %s%nMinimum : %s%n", max(tableau), min(tableau));
        triABulles(tableau);
        afficherTableau(tableau);
        System.out.printf("Maximum optimisé : %s%nMinimum optimisé : %s", maxOptimise(tableau), minOptimise(tableau));
    }

    /**
     * Affiche le tableau au format : "[.., .., ..]
     * @param tableau int[] tableau d'entier à afficher
     */
    public static void afficherTableau(int[] tableau) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < tableau.length; i++)
            builder.append(tableau[i]).append((i == tableau.length - 1 ? "]" : ", "));
        System.out.println(builder.toString());
    }

    /**
     * Effectue un tri à bulles sur le tableau d'entiers
     * @param tableau int[]
     */
    public static void triABulles(int[] tableau) {
        int taille = tableau.length;
        int tmp = 0;
        for (int i = 0; i < taille; i++) {
            for (int j = 1; j < (taille - i); j++) {
                if (tableau[j - 1] > tableau[j]) {
                    tmp = tableau[j - 1];
                    tableau[j - 1] = tableau[j];
                    tableau[j] = tmp;
                }
            }
        }
    }

    /**
     * Récupérer la valeur maximale du tableau d'entiers non trié
     * @param tableau int[]
     * @return int Valeur maximale
     */
    public static int max(int[] tableau) {
        int max = tableau[0];
        for (int i = 1; i < tableau.length; i++)
            if (tableau[i] > max)
                max = tableau[i];
        return max;
    }

    /**
     * Récupérer la valeur minimale du tableau d'entiers non trié
     * @param tableau int[]
     * @return int Valeur minimale
     */
    public static int min(int[] tableau) {
        int min = tableau[0];
        for (int i = 1; i < tableau.length; i++)
            if (tableau[i] < min)
                min = tableau[i];
        return min;
    }

    /**
     * Récupérer la valeur maximale du tableau d'entiers TRIE
     * @param tableau int[] TRIE
     * @return int Valeur maximale
     */
    public static int maxOptimise(int[] tableau) {
        return tableau[tableau.length - 1];
    }

    /**
     * Récupérer la valeur minimale du tableau d'entiers TRIE
     * @param tableau int[] TRIE
     * @return int Valeur minimale
     */
    public static int minOptimise(int[] tableau) {
        return tableau[0];
    }
}
