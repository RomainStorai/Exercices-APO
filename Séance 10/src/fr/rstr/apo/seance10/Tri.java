package fr.rstr.apo.seance10;

import java.util.Random;

public class Tri {

    /**
     * tableau original
     */
    int[] ref;
    /**
     * Tableau à trier
     */
    int[] tab;

    int[] draft;

    boolean affichage = false;
    /**
     * mémorisation de l'instant de départ
     */
    long t0;

    /**
     * Construit le tableau original avec des valeurs entières aléatoires
     * choisies entre 0 et 100 fois la longueur du tableau.
     *
     * @param n la longueur souhaitée du tableau. Doit être > 10 et &inf;=100000.
     */
    public Tri(int n, boolean aff) {
        affichage = aff;
        // correction éventuelle de la taille
        if (n < 10) {
            n = 10;
        }
        if (n > 100000) {
            n = 100000;
        }
        // dimensionnement du tableau
        ref = new int[n];
        tab = new int[ref.length];
        draft = new int[ref.length];

        // choix du générateur aléatoire
        Random rd = new Random();
        // calcul de la borne maximale des nombres à choisir.
        int borne = n * 10;
        // remplissage aléatoire
        for (int i = 0; i < ref.length; i++) {
            ref[i] = rd.nextInt(borne);
        }
    }

    /**
     * Méthode d'affichage du tableau indiqué. Seuls au maximum les 20 premiers
     * éléments sont affichés.
     *
     * @param tab le tableau à afficher.
     */
    public void afficher(int[] tab) {
        // on affiche au plus que les 20 premiers éléments
        for (int i = 0; i < tab.length && i < 20; i++) {
            System.out.print(tab[i] + " ");
        }
        // saut de ligne
        System.out.println();
    }

    /**
     * Méthode d'initialisation du tri. Elle affiche le tableau original,
     * effectue la recopie et mémorise l'heure de début.
     */
    public void debut() {
        if (affichage) {
            System.out.println("tableau à trier ");
            afficher(ref);
        }
        System.arraycopy(ref, 0, tab, 0, ref.length);
        t0 = System.currentTimeMillis();
    }

    /**
     * Méthode de gestion de la fin du tri, qui demande l'affichage du tableau
     * trié suivant la méthode indiquée et précise le temps de calcul.
     *
     * @param nomTri la dénomination de la méthode de tri utilisée.
     */
    public void fin(String nomTri) {
        //mémorisation du temps final
        long tf = System.currentTimeMillis();
        // affichage du tableau final
        if (affichage) {
            System.out.println("tableau trié");
            afficher(tab);
        }
        // calcul et affichage de la durée.
        long duree = tf - t0;
        System.out.println("résultat du " + nomTri + " durée " + duree + " ms");
    }

    /**
     * tri à bulle. La tableau est parcouru de la fin vers le début. Une boucle
     * secondaire en sens inverse sur la partie gauche fait remonter
     * progressivement tout élément plus grand que son successeur.
     */
    public void triBulle() {
        // initialisation du tri sur la copie du tableau original
        debut();
        // boucle principale décroissante
        for (int i = tab.length - 1; i > 0; i--) {
            // boucle secondaire sur la partie gauche
            for (int j = 0; j < i; j++) {
                // échange local si l'élément gauche est > à son successeur
                if (tab[j] > tab[j + 1]) {
                    int v = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = v;
                }
            }
        }
        fin("tri à bulle");
    }

    public void triFusion() {
        debut();

        triFusion(0, tab.length - 1);

        fin("tri fusion");
    }

    public void triFusion(int debut, int fin) {
        if (fin == debut)
            return;
        int n = fin + debut;

        int milieu = n / 2;

        // trier la moitié gauche
        triFusion(debut, milieu);

        // trier la moitié droite
        triFusion(milieu + 1, fin);

        fusion(debut, milieu, fin);
    }

    public void fusion(int i1, int i2, int i3) {
        /*
        [     ] [     ]
        i1  i2 (+1)  i3
         */

        int index1 = i1;
        int index2 = i2 + 1;
        int curseur = i1;

        while (index1 <= i2 && index2 <= i3) {
            if (tab[index1] < tab[index2]) {
                draft[curseur] = tab[index1];
                index1++;
            } else {
                draft[curseur] = tab[index2];
                index2++;
            }
            curseur++;
        }

        while (index1 <= i2) {
            draft[curseur] = tab[index1];
            curseur++;
            index1++;
        }

        while (index2 <= i3) {
            draft[curseur] = tab[index2];
            curseur++;
            index2++;
        }

        if (i3 + 1 - i1 >= 0) System.arraycopy(draft, i1, tab, i1, i3 + 1 - i1);
    }

}
