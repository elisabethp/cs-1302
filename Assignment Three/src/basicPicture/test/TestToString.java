package basicPicture.test;

import basicPicture.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by Ben on 2/9/2016.
 */
public class TestToString {

    private String val =
            "line from (17.0,23.0) to (-14.0,-5.0)\n"+
                    "line from (-14.0,-5.0) to (3.0,-18.0)\n"+
                    "line from (3.0,-18.0) to (17.0,23.0)\n"+
                    "circle of radius 2.0 centered at (-14.0,-5.0)\n"+
                    "line from (3.0,-18.0) to (6.0,-18.0)\n"+
                    "line from (6.0,-18.0) to (6.0,-14.0)\n"+
                    "line from (6.0,-14.0) to (3.0,-14.0)\n"+
                    "line from (3.0,-14.0) to (3.0,-18.0)\n"+
                    "line from (0.0,0.0) to (3.0,0.0)\n"+
                    "line from (3.0,0.0) to (0.0,4.0)\n"+
                    "line from (0.0,4.0) to (0.0,0.0)\n"+
                    "circle of radius 2.0 centered at (3.0,0.0)\n"+
                    "line from (0.0,4.0) to (3.0,4.0)\n"+
                    "line from (3.0,4.0) to (3.0,8.0)\n"+
                    "line from (3.0,8.0) to (0.0,8.0)\n"+
                    "line from (0.0,8.0) to (0.0,4.0)\n";



    private Composite cmp2;

    @Before
    public void  setup() {
        PicPoint p0 = new PicPoint(0,0);
        PicPoint p1 = new PicPoint(3,0);
        PicPoint p2 = new PicPoint(0,4);
        Triangle t1 = new Triangle(p0,p1,p2);
        Circle c1 = new Circle(p1, 2);
        Rectangle r1 = new Rectangle(p2, 3, 4);
        Composite cmp1 = new Composite();
        cmp1.getComponents().add(t1);
        cmp1.getComponents().add(c1);
        cmp1.getComponents().add(r1);


        PicPoint p3 = new PicPoint(17, 23);
        PicPoint p4 = new PicPoint(-14,-5);
        PicPoint p5 = new PicPoint(3, -18);
        Triangle t2 = new Triangle(p3,p4,p5);
        Circle c2 = new Circle(p4, 2);
        Rectangle r2 = new Rectangle(p5, 3, 4);
        cmp2 = new Composite();
        cmp2.getComponents().add(t2);
        cmp2.getComponents().add(c2);
        cmp2.getComponents().add(r2);
        cmp2.getComponents().add(cmp1);

    }

    @Test
    public void testNestedComposite() {
        String v = cmp2.toString();
        assertEquals("toString has an error",val, v );
    }
}
