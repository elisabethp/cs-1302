import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Array;
import java.util.*;


/**
 * Created by INTEL on 3/26/2016.
 */

public class CircleBounds extends Pane {

    private double maxX;
    private double maxY;
    private double minX;
    private double minY;
    private final int RADIUS = 10;
    private static Rectangle r = new Rectangle();

    public CircleBounds() {
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(.5);
        getChildren().add(r);

        setOnMouseClicked(addOrRemove);
    }

    private EventHandler<MouseEvent> addOrRemove =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    if (event.getButton() == MouseButton.PRIMARY) {
                        Circle c = new Circle(event.getX(), event.getY(),
                                RADIUS, Color.BISQUE);
                        getChildren().add(c);
                        reshape(c);
                    }
                    else if (event.getButton() == MouseButton.SECONDARY && !event.getTarget().equals(r)) {
                        getChildren().remove(event.getTarget());
                        reshape(new Circle(RADIUS));
                    }
                }
            };

    private void reshape(Circle c) {
        maxX = findMaxX();
        minX = findMinX();
        maxY = findMaxY();
        minY = findMinY();

        //set new rectangle values
        r.setX(minX - c.getRadius());
        r.setY(maxY - c.getRadius());
        r.setHeight((minY - maxY) + (c.getRadius()*2));
        r.setWidth((maxX - minX) + (c.getRadius()*2));
    }


    /**
     * The following methods iterate through the children of CircleBoundsPane
     * and save the corresponding x-values or y-values to an arrayList where
     * they are sorted in ascending order.
     *
     * @return -- returns the max/min value of the generated arrayLists,
     * depending on what the method is searching for
     */

    private double findMaxX() { //right-most x value
        ArrayList<Double> aList = new ArrayList<>();
        Iterator i = getChildren().iterator();

        while (i.hasNext()) {
            Object o = i.next();

            if (!(o.equals(r))){ //don't want to save the rectangle in the arrayList
                Circle m = (Circle)o;
                aList.add(m.getCenterX());
            }
        }

        Collections.sort(aList);

        return aList.get(aList.size() - 1);
    }

    private double findMinX() { //left-most x value
        ArrayList<Double> aList = new ArrayList<>();
        Iterator i = getChildren().iterator();

        while (i.hasNext()) {
            Object o = i.next();

            if (!(o.equals(r))){ //don't want to save the rectangle in the arrayList
                Circle m = (Circle)o;
                aList.add(m.getCenterX());
            }
        }

        Collections.sort(aList);

        return aList.get(0);
    }

    private double findMaxY() { //top-most y value
        ArrayList<Double> aList = new ArrayList<>();
        Iterator i = getChildren().iterator();

        while (i.hasNext()) {
            Object o = i.next();

            if (!(o.equals(r))){ //don't want to save the rectangle in the arrayList
                Circle m = (Circle)o;
                aList.add(m.getCenterY());
            }
        }

        Collections.sort(aList);

        return aList.get(0);
    }

    private double findMinY() { //bottom-most y value
        ArrayList<Double> aList = new ArrayList<>();
        Iterator i = getChildren().iterator();

        while (i.hasNext()) {
            Object o = i.next();

            if (!(o.equals(r))){ //don't want to save the rectangle in the arrayList
                Circle m = (Circle)o;
                aList.add(m.getCenterY());
            }
        }

        Collections.sort(aList);

        return aList.get(aList.size() - 1);
    }

}
