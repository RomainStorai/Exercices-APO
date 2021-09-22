package fr.rstr.seance2.exo2;

public class TestRect {

    public static void main(String[] args) {
        Rect r1 = new Rect(1, 15, 3, 8); // x1,x2,y1,y2
        System.out.println("Rectangle " + r1); //écrit :Rectangle R1 (1 , 3 , 15 , 8 )
        Rect r2 = new Rect(5, 7, 12, 10);
        System.out.println(r2); // R2 (5 , 10 , 7 , 12)
        System.out.println(r2.surface()); //4
    }
}
