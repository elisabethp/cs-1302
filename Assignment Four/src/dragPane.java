import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * Created by INTEL on 3/2/2016.
 */
public class dragPane extends Pane {

    private Circle c1 = new Circle(40, 40, 10);
    private Circle c2 = new Circle(120, 150, 10);
    private Line l1 = new Line();
    private Text t1;

    public dragPane() {

        l1.startXProperty().bind(c1.centerXProperty());
        l1.startYProperty().bind(c1.centerYProperty());

        l1.endXProperty().bind(c2.centerXProperty());
        l1.endYProperty().bind(c2.centerYProperty());

        c1.setOnMouseDragged(e -> dragACircle(e));
        c1.setOnMousePressed(startDragHandler);

        c2.setOnMouseDragged(e -> dragACircle(e));
        c2.setOnMousePressed(startDragHandler);

        t1 = new Text(getMidPoint(c1.getCenterX(), c2.getCenterX()),
                getMidPoint(c1.getCenterY(), c2.getCenterY()),
                getDistance(c1.getCenterX(), c2.getCenterY()));
        t1.xProperty().bind((l1.startXProperty().add(l1.endXProperty()).divide(2)));
        t1.yProperty().bind((l1.startYProperty().add(l1.endYProperty()).divide(2)));


        this.getChildren().addAll(c1, c2, l1, t1);
    }

    public String getDistance(double x, double y) {
        int ans = (int)Math.hypot(c2.getCenterX()-c1.getCenterX(),
                c2.getCenterY()-c1.getCenterY());
        String strans = Integer.toString(ans);
        return strans;
    }

    public double getMidPoint(double p1, double p2) {
        return (p1 + p2) / 2;
    }

    public void updateDistance () {
        t1.setText(getDistance(c1.getCenterX(), c2.getCenterY()));
    }

    private void dragACircle(MouseEvent e) {
        Circle  et = (Circle)e.getTarget();
        double mouseX = e.getX();
        double mouseY = e.getY();
        et.setCenterX(mouseX + offsetX);
        et.setCenterY(mouseY + offsetY);
        updateDistance();
    }

    private double offsetX, offsetY;

    private EventHandler<MouseEvent> startDragHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Circle  et = (Circle)event.getTarget();
                    double mouseX = event.getX();
                    double mouseY = event.getY();
                    double circX = et.getCenterX();
                    double circY = et.getCenterY();
                    offsetX = circX - mouseX;
                    offsetY = circY - mouseY;
                    updateDistance();
                }
            };
}
