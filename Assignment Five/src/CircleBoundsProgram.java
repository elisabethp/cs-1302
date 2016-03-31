/**
 * Created by INTEL on 3/26/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CircleBoundsProgram extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CircleBounds cb = new CircleBounds();

        Scene scene = new Scene(cb, 500, 500);

        primaryStage.setTitle("Drag Circles"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
