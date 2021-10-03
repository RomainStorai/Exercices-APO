package fr.rstr.apo.seance4;

import java.util.Scanner;

public class Etudiant {

    private static int numActuel = 1;

    private final int num;
    private final String prenom, nom;
    private double[] notes;

    public Etudiant(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        num = numActuel;
        numActuel++;
    }

    /**
     * Récupérer l'identifiant de l'étudiant
     * @return int identifiant
     */
    public int getNum() {
        return num;
    }

    /**
     * Récupérer le prénom de l'étudiant
     * @return String prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Récupérer le nom de l'étudiant
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupérer le tableau de notes de l'élève
     * @return double[] Notes
     */
    public double[] getNotes() {
        return notes;
    }

    /**
     * Moyenne de l'élève
     * @return double Moyenne de l'élève
     */
    public double getMoyenne() {
        double somme = 0;
        for (double note : notes)
            somme += note;
        return somme / notes.length;
    }

    /**
     * DOIT ETRE APPELEE JUSTE APRES LA CREATION DE L'INSTANCE
     *
     * Permet de renseigner les notes au Scanner de l'étudiant
     * @param clavier Scanner console
     */
    public void ajouterLesNotes(Scanner clavier) {
        int nombreNotes = 7;
        while (nombreNotes > 6) {
            System.out.print("Nombre de notes (max 6) : ");
            nombreNotes = clavier.nextInt();
        }
        notes = new double[nombreNotes];

        System.out.println("Saisissez les " + nombreNotes + " notes");
        for (int i = 0; i < nombreNotes; i++)
            notes[i] = clavier.nextDouble();
    }
}
