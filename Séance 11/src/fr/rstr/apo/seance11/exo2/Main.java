package fr.rstr.apo.seance11.exo2;

public class Main {

    public static void main(String[] args) {
        Arbre<Integer> arbre1 = new Arbre<>(new Arbre<>(), 6, new Arbre<>());
        Arbre<Integer> arbre2 = new Arbre<>(new Arbre<>(), 5, new Arbre<>());
        Arbre<Integer> arbre3 = new Arbre<>(arbre1, 60, arbre2);
        Arbre<Integer> arbre4 = new Arbre<>(new Arbre<>(), 12, new Arbre<>());
        Arbre<Integer> arbre5 = new Arbre<>(arbre3, 2, arbre4);
        System.out.println(arbre5.toString());
    }
}
