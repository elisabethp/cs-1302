package basicPicture.program;

import basicPicture.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by epetitbo on 2/10/2016.
 */
public class SortAList {
    public static void main(String[] args) {
        ArrayList<Geometric> listOfShapes = new ArrayList<>();

        PicPoint base = new PicPoint(1, 1);
        PicPoint v1 = new PicPoint(2, 2);
        PicPoint v2 = new PicPoint(0,0);

        Circle c1 = new Circle(base, 1);
        Rectangle r1 = new Rectangle(base, 2, 1);
        Triangle t1 = new Triangle(base, v1, v2);

        listOfShapes.add(c1);
        listOfShapes.add(r1);
        listOfShapes.add(t1);

        System.out.println(listOfShapes);
        for (Geometric g : listOfShapes) {
            System.out.println(g.getArea());
        }

        Collections.sort(listOfShapes);

        System.out.println(listOfShapes);
        for (Geometric g : listOfShapes) {
            System.out.println(g.getArea());
        }
    }
}
