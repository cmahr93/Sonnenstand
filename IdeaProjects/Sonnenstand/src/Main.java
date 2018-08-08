import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DinAlgorithm;


public class Main extends Application {

    Stage window;
    Scene scene;
    Label label;
    Button buttonStart;
    TextField year, month, day, hour, minute, second;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Sonnenstand");

        label = new Label("Welcome to the first scene!");

        buttonStart = new Button();
        buttonStart.setText("Start");

        year = new TextField();
        month = new TextField();
        day = new TextField();
        hour = new TextField();
        minute = new TextField();
        second = new TextField();

        //Layout 1 - children are laid out in vertical column
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, year, month, day, hour, minute, second, buttonStart);
        scene = new Scene(layout, 400, 600);

        window.setScene(scene);
        window.show();

        buttonStart.setOnAction(e -> {
            DinAlgorithm dinAlgorithm = new DinAlgorithm();
            double[] sunPosition = dinAlgorithm.sunPosition();
            System.out.println("The position of the sun is: " + sunPosition[0] + " " + sunPosition[1]);
        });
    }
}