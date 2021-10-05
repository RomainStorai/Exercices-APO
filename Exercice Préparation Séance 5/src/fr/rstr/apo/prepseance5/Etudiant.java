package fr.rstr.apo.prepseance5;

import java.util.ArrayList;

public class Etudiant {

    String nom, prenom;
    ArrayList<Double> notes = new ArrayList<>();

    public Etudiant(String prenom, String nom, int id) {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Permet d'ajouter une note à un élève
     *
     * @param note à ajouter
     */
    public void ajouterNote(double note) {
        notes.add(note);
    }

    /**
     * Permet de calculer la moyenne de l'élève
     *
     * @return moyenne
     */
    public double moyenne() {
        double somme = 0;
        for (Double note : notes)
            somme += note;
        return somme / notes.size();
    }

    /**
     * Permet de récupérer la liste des notes sous forme de chaine de caractères
     *
     * @return liste des notes
     */
    public String listeNotes() {
        return notes.toString();
    }
}
