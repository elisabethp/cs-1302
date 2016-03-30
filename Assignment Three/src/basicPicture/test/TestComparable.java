package basicPicture.test;

import basicPicture.Circle;
import basicPicture.PicPoint;
import basicPicture.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ben on 2/7/2016.
 */
public class TestComparable {

    @Test
    public void testCompareTo1() {
        PicPoint p0 = new PicPoint(0,0);
        Rectangle r = new Rectangle(p0, 2,3);
        Circle c =new Circle(p0, 1.5);
        assertEquals("compareTo not implemented correctly", -1, r.compareTo(c));
    }


    @Test
    public void testCompareTo2() {
        PicPoint p0 = new PicPoint(0,0);
        Rectangle r = new Rectangle(p0, 2,3);
        Circle c =new Circle(p0, 1.5);
        assertEquals("compareTo not implemented correctly", 1, c.compareTo(r));
    }


    @Test
    public void testCompareTo3() {
        PicPoint p0 = new PicPoint(0,0);
        Rectangle r1 = new Rectangle(p0, 10, 6);
        Rectangle r2 = new Rectangle(p0, 5, 12);
        assertEquals("compareTo not implemented correctly", 0, r1.compareTo(r2));
    }


}
