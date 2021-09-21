package fr.rstr.seance2.exo1;

public class TestComplexe {

    public static void main(String[] args) {
        //question 1
        Complexe a = new Complexe(3, 6);
        Complexe b = new Complexe(0, 6);
        //question 2
        System.out.println("a = " + a); //a = 3.0 + 6.0*i
        System.out.println("b = " + b); //b = 6.0*i
        //question 3
        Complexe c = a.ajout(b);
        System.out.println("a + b = " + c); //a+b = 3.0 + 12.0*i
        //question 3b
        Complexe d = a.multiplie(b);
        System.out.println("a + b = " + d); //a+b = -36.0 + 18.0*i&
    }
}
