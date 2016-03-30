/**
 * Created by INTEL on 3/6/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DragCircles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        dragPane dp = new dragPane();

//        Pane p = new Pane();
//        p.getChildren().addAll(dp);

        Scene scene = new Scene(dp, 500, 500);

        primaryStage.setTitle("Drag Circles"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }


}
