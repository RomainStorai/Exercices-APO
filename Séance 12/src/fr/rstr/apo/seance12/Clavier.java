package fr.rstr.apo.seance12;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
    // pour tester
    public static void main(String[] args) {
        Clavier clav = new Clavier();
        clav.lire();
    }

    public void lire() {
        ArrayList<Immatriculation> li = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int code;

            try {
                System.out.print("code (0 arret, 1 France, 2 Espagne) : ");
                code = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Attention vous n'avez pas rentré de chiffre !");
                break;
            }

            sc.nextLine();

            if (code == 0)
                break;

            System.out.print("immatriculation : ");
            String s = sc.nextLine();

            try {
                switch (code) {
                    case 1 -> {
                        Immatriculation immat = new Francaise(s);
                        li.add(immat);
                    }
                    case 2 -> {
                        Immatriculation immat = new Espagnole(s);
                        li.add(immat);
                    }
                    default -> throw new Exception("code pays inconnu :" + code);
                }
            } catch (ImmatException exception) {
                System.err.println(exception.getMessage());
            } catch (Exception exception) {
                System.err.println("Le code pays n'est pas reconnu...");
            }
        }


        System.out.println("Immatriculations saisies :");
        for (Immatriculation immat : li)
            System.out.println(immat);

        System.out.println("Au revoir");
    }
}