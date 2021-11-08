package fr.rstr.apo.seance8.exo2;

public class Main {

    public static void main(String[] args) {
        //Premier train composé de locomotives et de voitures indépendentes
        //Attention données 100% fictives!
        Train train1 = new Train("Intercité 32553");
        Locomotive locomotive1 = new Locomotive("Alstom TF2133", 25, 26, 50, 2500);
        Locomotive locomotive2 = new Locomotive("Alstom TF2133", 25, 26, 50, 2500);
        Voiture voiture1 = new Voiture(1, 200, "Alstom V2342", 10, 25, 60);
        Voiture voiture2 = new Voiture(2, 200, "Alstom V2342", 10, 25, 60);
        Voiture voiture3 = new Voiture(3, 200, "Alstom V2342", 10, 25, 60);
        Voiture voiture4 = new Voiture(4, 200, "Alstom V2342", 10, 25, 60);
        train1.ajouterSegment(locomotive1);
        train1.ajouterSegment(voiture1);
        train1.ajouterSegment(voiture2);
        train1.ajouterSegment(voiture3);
        train1.ajouterSegment(voiture4);
        train1.ajouterSegment(locomotive2);

        //Deuxième train composé de deux rames automotrices
        Train train2 = new Train("TER 563749");
        ElementAutomoteur rame1 = new ElementAutomoteur(200, 200,
                "Bombardier 12342", 30, 60, 60);
        ElementAutomoteur rame2 = new ElementAutomoteur(200, 200,
                "Bombardier 12342", 30, 60, 60);
        train2.ajouterSegment(rame1);
        train2.ajouterSegment(rame2);

        //Affichage
        System.out.println(train1);
        System.out.println(train2);


        //On supprime une voiture du premier train et on vérifie que les valeurs
        //sont bien mises à jour
        train1.enleverSegment(1); // On enlève la voiture 1 par position
        train1.enleverSegment(voiture3); // On enlève la voiture 3 par référence

        //On vérifie que c'est mis à jour:

        System.out.println(train1);

    }
}
