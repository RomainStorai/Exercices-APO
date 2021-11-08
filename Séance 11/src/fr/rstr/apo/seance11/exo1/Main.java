package fr.rstr.apo.seance11.exo1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Fenetre fenetre = new Fenetre(primaryStage);
        fenetre.setValues(new Nat(), new Nat(), new Nat());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        NatInterface n2 = new Nat().succ().succ();
        n2.afficher();

        NatInterface n3 = n2.succ();
        n3.afficher();

        launch(args);

        n2.add(n3).afficher();
        n2.mult(n3).afficher();
    }
    
}