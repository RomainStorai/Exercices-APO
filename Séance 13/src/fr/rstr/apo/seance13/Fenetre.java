package fr.rstr.apo.seance13;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Fenetre {

    private final Circle soleil = new Circle(100, 70, 50, Color.YELLOW);
    private final Rectangle champ = new Rectangle(50, 50, Color.GREEN);

    public Fenetre(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);

        borderPane.setRight(createControls());
        borderPane.setCenter(createDrawPane());
        borderPane.setTop(createMenu());

        stage.setTitle("Mon super soleil");
        stage.setScene(scene);
        stage.show();
    }

    private MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();

        // Fichier
        Menu menuFichier = new Menu("Fichier");

        MenuItem miQuitter = new MenuItem("Quitter");
        miQuitter.setOnAction(event -> System.exit(0));

        menuFichier.getItems().add(miQuitter);

        // Couleur
        Menu menuCouleur = new Menu("Couleur");

        RadioMenuItem rmiJaune = new RadioMenuItem("Jaune");
        RadioMenuItem rmiOrange = new RadioMenuItem("Orange");
        RadioMenuItem rmiRouge = new RadioMenuItem("Rouge");

        rmiJaune.setOnAction(event -> soleil.setFill(Color.YELLOW));
        rmiOrange.setOnAction(event -> soleil.setFill(Color.ORANGE));
        rmiRouge.setOnAction(event -> soleil.setFill(Color.RED));

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(rmiJaune, rmiOrange, rmiRouge);
        toggleGroup.selectToggle(rmiJaune);

        menuCouleur.getItems().addAll(rmiJaune, rmiOrange, rmiRouge);

        // Ajout au MenuBar
        menuBar.getMenus().addAll(menuFichier, menuCouleur);

        return menuBar;
    }

    private Pane createControls() {
        GridPane pane = new GridPane();

        Button haut = new Button("Haut");
        Button bas = new Button("Bas");
        Button gauche = new Button("Gauche");
        Button droite = new Button("Droite");

        haut.setOnAction(event -> soleil.setCenterY(soleil.getCenterY() - 10));
        bas.setOnAction(event -> {
            new AnimationTimer() {
                private long top;
                private double startY;

                @Override
                public void start() {
                    top = System.nanoTime();
                    startY = soleil.getCenterY();
                    super.start();
                }

                @Override
                public void handle(long now) {
                    long delta = now - top;
                    soleil.setCenterY(startY + 10 * delta / 1E9);
                    if (delta/1E9 > 2)
                        stop();
                }
            }.start();
        });
        gauche.setOnAction(event -> soleil.setCenterX(soleil.getCenterX() - 10));
        droite.setOnAction(event -> soleil.setCenterX(soleil.getCenterX() + 10));

        Label libX = new Label("x");
        Label libY = new Label("y");

        TextField tfX = new TextField();
        TextField tfY = new TextField();

        tfX.setPrefWidth(50);
        tfY.setPrefWidth(50);

        Bindings.bindBidirectional(tfX.textProperty(), soleil.centerXProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(tfY.textProperty(), soleil.centerYProperty(), new NumberStringConverter());


        pane.add(haut, 1, 0);
        pane.add(gauche, 0, 1);
        pane.add(droite, 2, 1);
        pane.add(bas, 1, 2);
        pane.add(libX, 0, 3);
        pane.add(libY, 0, 4);
        pane.add(tfX, 1, 3, 2, 1);
        pane.add(tfY, 1, 4, 2, 1);
        return pane;
    }

    private Pane createDrawPane() {
        Pane pane = new Pane();

        pane.getChildren().addAll(soleil, champ);

        champ.widthProperty().bind(pane.widthProperty());
        champ.yProperty().bind(pane.heightProperty().subtract(champ.getHeight()));
        return pane;
    }
}
