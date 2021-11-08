package fr.rstr.apo.seance11.exo1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Fenetre {


    private NatInterface currentValueX;
    private NatInterface currentValueY;
    private NatInterface currentResult;


    public void setValues(NatInterface x, NatInterface y, NatInterface r) {
        currentValueX = x;
        currentValueY = y;
        currentResult = r;
    }


    Fenetre(Stage st) {


        // organisation principale verticale
        HBox hb = new HBox();
        Scene sc = new Scene(hb);
        st.setScene(sc);

        Label labelX = new Label("x");
        Label labelY = new Label("Y");
        Label labelResult = new Label("result");

        TextField valueX = new TextField("0");//currentValueX.toString());
        TextField valueY = new TextField("0");//currentValueX.toString());
        TextField valueResult = new TextField("0");//currentResult.toString());
        TextField valueResultP = new TextField("0");

        TextField valueXP = new TextField("0");
        TextField valueYP = new TextField("0");

        GridPane gridValues = new GridPane();
        gridValues.setPadding(new Insets(5, 5, 5, 5));
        gridValues.setHgap(5);
        gridValues.setVgap(5);
        gridValues.add(labelX, 0, 0);
        gridValues.add(labelY, 0, 1);
        gridValues.add(labelResult, 0, 2);
        gridValues.add(valueX, 1, 0);
        gridValues.add(valueXP, 2, 0);
        gridValues.add(valueY, 1, 1);
        gridValues.add(valueYP, 2, 1);
        gridValues.add(valueResult, 1, 2);
        gridValues.add(valueResultP, 2, 2);

        GridPane grid = new GridPane();
        hb.getChildren().add(grid);
        hb.getChildren().add(gridValues);

        // espaces au sein du GridPane
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setHgap(5);
        grid.setVgap(5);

        Button bSucc = new Button();
        bSucc.setText("succ");

        bSucc.setOnAction((ActionEvent event) -> {
            System.out.println("succ");
            currentResult = currentResult.succ();
            valueResult.setText(currentResult.intValue() + "");
            valueResultP.setText(currentResult.toString());
        });

        grid.add(bSucc, 0, 0);

        Button bAdd = new Button(" + ");

        bAdd.setOnAction((ActionEvent e) -> {
            currentValueX = createNat(Integer.parseInt(valueX.getText()));
            currentValueY = createNat(Integer.parseInt(valueY.getText()));
            currentResult = currentValueX.add(currentValueY);
            valueXP.setText(currentValueX.toString());
            valueYP.setText(currentValueY.toString());
            valueResult.setText(currentResult.intValue() + "");
            valueResultP.setText(currentResult.toString());
        });

        grid.add(bAdd, 1, 0);

        Button bMult = new Button(" * ");
        bMult.setOnAction((ActionEvent e) -> {
            currentValueX = createNat(Integer.parseInt(valueX.getText()));
            currentValueY = createNat(Integer.parseInt(valueY.getText()));
            currentResult = currentValueX.mult(currentValueY);
            valueXP.setText(currentValueX.toString());
            valueYP.setText(currentValueY.toString());
            valueResult.setText(currentResult.intValue() + "");
            valueResultP.setText(currentResult.toString());
        });

        grid.add(bMult, 0, 1);


        Button bC = new Button(" C ");
        bC.setOnAction((ActionEvent e) -> {
            currentValueX = currentValueX.zero();
            currentValueY = currentValueX.zero();
            currentResult = currentValueX.zero(); //currentValueX.isEqual(currentValueY);
            valueResult.setText(currentResult.intValue() + "");
            valueXP.setText(currentValueX.toString());
            valueYP.setText(currentValueY.toString());
            valueX.setText(currentValueX.intValue() + "");
            valueY.setText(currentValueY.intValue() + "");
            valueResultP.setText(currentResult.toString());
        });

        grid.add(bC, 0, 2);

        Button bLeq = new Button(" <= ");

        bLeq.setOnAction((ActionEvent e) -> {
            currentValueX = createNat(Integer.parseInt(valueX.getText()));
            currentValueY = createNat(Integer.parseInt(valueY.getText()));
            boolean result = currentValueX.leq(currentValueY);
            valueResult.setText(result + "");
        });
        grid.add(bLeq, 1, 2);


        st.setTitle("Nat");
        st.setScene(sc);
        st.show();

    }

    /**
     * Création d'un entier sous la forme de Peano.
     *
     * @param value
     * @return
     */
    private NatInterface createNat(int value) {
        NatInterface e = currentValueX.zero();
        while (e.intValue() != value) {
            e = e.succ();
        }
        return e;
    }

}
