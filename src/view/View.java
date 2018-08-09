package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import controller.MainController;


/** Die View-Klasse enthält nur die Präsentation. Hier sollte man keinerlei Programmlogik finden.
 * Alle Berechnungen und Reaktionen auf Benutzeraktionen sollten im Controller stehen
 */
public class View extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sonnenstand");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Sonnenstand");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label labelDate = new Label("Datum: ");
        grid.add(labelDate, 0, 1);
        TextField textFieldDate1 = new TextField();
        grid.add(textFieldDate1, 1 ,1);
        TextField textFieldDate2 = new TextField();
        grid.add(textFieldDate2, 2,1);
        TextField textFieldDate3 = new TextField();
        grid.add(textFieldDate3, 3,1);

        Label labelTime = new Label("Uhrzeit: ");
        grid.add(labelTime, 0, 2);
        TextField textFieldTime1 = new TextField();
        grid.add(textFieldTime1, 1, 2);
        TextField textFieldTime2 = new TextField();
        grid.add(textFieldTime2, 2, 2);
        TextField textFieldTime3 = new TextField();
        grid.add(textFieldTime3, 3, 2);

        Label labelLocation = new Label("Ort: ");
        grid.add(labelLocation, 0, 3);
        TextField textFieldLocation1 = new TextField();
        grid.add(textFieldLocation1, 1, 3);
        TextField textFieldLocation2 = new TextField();
        grid.add(textFieldLocation2, 2, 3);

        Button button = new Button("Start");
        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(button);
        grid.add(hbButton, 1, 4);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        button.setOnAction(e -> {
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Sonnenhöhenwinkel: " + "Azimuth: "); //TODO: Ergebnis einfügen
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}