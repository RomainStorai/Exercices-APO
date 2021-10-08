package fr.rstr.apo.seance5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListeDEntiers {

    // Attributs
    private List<Integer> liste = new ArrayList<>();

    /**
     * Ajouter nombre nombres générés aléatoirement entre 0 et max à la liste
     *
     * @param nombre de nombres à ajouter
     * @param max    borne maximale de la génération aléatoire
     */
    public void ajouter(int nombre, int max) {
        Random random = new Random();
        for (int i = 0; i < nombre; i++)
            liste.add(random.nextInt(max + 1));
        Collections.sort(liste);
    }

    /**
     * Compter le nombre d'occurences du nombre entier
     *
     * @param entier à compter
     * @return nombre de fois qu'entier apparaît
     */
    public int compter(int entier) {
        int somme = 0;
        for (Integer integer : liste)
            if (integer == entier)
                somme++;
        return somme;
    }

    /**
     * Permet de supprimer l'entier de la liste
     *
     * @param entier à supprimer
     */
    public void supprimer(int entier) {
        liste.removeAll(Collections.singleton(entier));
    }

    /**
     * Crée une nouvelle ListeDEntiers résultant de la fusion de cette liste avec liste2. Seulement les nombres en commun apparaîtront.
     *
     * @param liste2 à fusionner
     * @return nouvelle ListeDEntiers
     */
    public ListeDEntiers valeursEnCommunAvec(ListeDEntiers liste2) {
        List<Integer> dejaVu = new ArrayList<>();
        ListeDEntiers nouveau = new ListeDEntiers();

        for (Integer integer : liste2.liste)
            if (!dejaVu.contains(integer) && liste.contains(integer))
                dejaVu.add(integer);

        Collections.sort(dejaVu);
        nouveau.liste = dejaVu;
        return nouveau;
    }

    /**
     * Permet de supprimer les doublons d'une liste
     *
     * @return nombre de doublons supprimés
     */
    public int dedoublonner() {
        List<Integer> doublons = new ArrayList<>();
        int sommeSuppr = 0;
        for (Integer integer : liste) {
            if (doublons.contains(integer))
                continue;
            int compte = compter(integer);
            if (compte >= 2) {
                sommeSuppr += compte - 1;
                doublons.add(integer);
            }
        }

        for (Integer doublon : doublons) {
            supprimer(doublon);
            liste.add(doublon);
        }

        Collections.sort(liste);

        return sommeSuppr;
    }

    @Override
    public String toString() {
        return liste.toString();
    }
}
