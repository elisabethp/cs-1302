package basicPicture.test;

import basicPicture.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Ben on 2/9/2016.
 */
public class TestComposite {

    private Picture pic1, pic2;

    public static final double TOLERANCE = 1e-10;


    @Before
    public void setup() {
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
        pic1 = cmp1;

        PicPoint p3 = new PicPoint(17, 23);
        PicPoint p4 = new PicPoint(-14,-5);
        PicPoint p5 = new PicPoint(3, -18);
        Triangle t2 = new Triangle(p3,p4,p5);
        Circle c2 = new Circle(p4, 2);
        Rectangle r2 = new Rectangle(p5, 3, 4);
        Composite cmp2 = new Composite();
        cmp2.getComponents().add(t2);
        cmp2.getComponents().add(c2);
        cmp2.getComponents().add(r2);
        cmp2.getComponents().add(pic1);
        pic2 = cmp2;
    }

    @Test
    public void testSimpleCompositeSize() {
        assertEquals("Composite has the wrong number of elements", 3, ((Composite)pic1).getComponents().size());
    }

    @Test
    public void testNestedCompositeSize() {
        assertEquals("Composite has the wrong number of elements", 4, ((Composite)pic2).getComponents().size());
    }

    @Test
    public void testNestedNestedCompositeSize() {
        Composite t1 = (Composite)pic2;
        Composite t2 = (Composite)t1.getComponents().get(3);
        assertEquals("Composite has the wrong number of elements", 3, t2.getComponents().size());
    }

    @Test
    public void testCompositeLocation() {
        assertTrue("Composite base point incorrect x", Double.isNaN(pic1.getBase().getX()));
        assertTrue("Composite base point incorrect y", Double.isNaN(pic1.getBase().getY()));
    }

}
