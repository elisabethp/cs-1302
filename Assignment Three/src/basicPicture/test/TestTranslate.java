package basicPicture.test;

import basicPicture.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Ben on 2/9/2016.
 */
public class TestTranslate {

    private Composite pic1, pic2;
    private Geometric c1, r1;
    Triangle t1;
    PicPoint p0, p1, p2;

    public static final double TOLERANCE = 1e-10;


    @Before
    public void setup() {
        p0 = new PicPoint(0,0);
        p1 = new PicPoint(3,0);
        p2 = new PicPoint(0,4);
        PicPoint p1A = new PicPoint(3,0);
        PicPoint p2A = new PicPoint(0,4);
        t1 = new Triangle(p0,p1,p2);
        c1 = new Circle(p1A, 2);
        r1 = new Rectangle(p2A, 3, 4);
        Composite cmp1 = new Composite();
        cmp1.getComponents().add(t1);
        cmp1.getComponents().add(c1);
        cmp1.getComponents().add(r1);
        pic1 = cmp1;

        PicPoint p3 = new PicPoint(17, 23);
        PicPoint p4 = new PicPoint(-14,-5);
        PicPoint p5 = new PicPoint(3, -18);
        PicPoint p4A = new PicPoint(-14,-5);
        PicPoint p5A = new PicPoint(3, -18);
        Triangle t2 = new Triangle(p3,p4,p5);
        Circle c2 = new Circle(p4A, 2);
        Rectangle r2 = new Rectangle(p5A, 3, 4);
        Composite cmp2 = new Composite();
        cmp2.getComponents().add(t2);
        cmp2.getComponents().add(c2);
        cmp2.getComponents().add(r2);
        cmp2.getComponents().add(pic1);
        pic2 = cmp2;
    }

    @Test
    public  void translateAPoint() {
        p2.translate(3,7);
        // p2 = new PicPoint(0,4);
        assertEquals("point x coordinate not translated correctly", 3, p2.getX(),TOLERANCE);
        assertEquals("point y coordinate not translated correctly", 11, p2.getY(),TOLERANCE);
    }

    @Test
    public  void translateACircle() {
        c1.translate(-5, 23);
        //  p1 = new PicPoint(3,0);
        assertEquals("point x coordinate not translated correctly", -2, c1.getBase().getX(),TOLERANCE);
        assertEquals("point y coordinate not translated correctly", 23, c1.getBase().getY(),TOLERANCE);
    }

    @Test
    public  void translateATriangleBase() {
        t1.translate(14, -19);
        //   p0 = new PicPoint(0,0);
        //p1 = new PicPoint(3,0);
        //p2 = new PicPoint(0,4);
        assertEquals("triangle base x coordinate not translated correctly", 14, t1.getBase().getX(),TOLERANCE);
        assertEquals("triangle base y coordinate not translated correctly", -19, t1.getBase().getY(),TOLERANCE);
    }

    @Test
    public  void translateATriangleV1() {
        t1.translate(14, -19);
        //   p0 = new PicPoint(0,0);
        //p1 = new PicPoint(3,0);
        //p2 = new PicPoint(0,4);
        assertEquals("triangle v1 x coordinate not translated correctly", 17, t1.getV1().getX(),TOLERANCE);
        assertEquals("triangle v1 y coordinate not translated correctly", -19, t1.getV1().getY(),TOLERANCE);
    }


    @Test
    public  void translateATriangleV2() {
        t1.translate(14, -19);
        //   p0 = new PicPoint(0,0);
        //p1 = new PicPoint(3,0);
        //p2 = new PicPoint(0,4);
        assertEquals("triangle v2 x coordinate not translated correctly", 14, t1.getV2().getX(),TOLERANCE);
        assertEquals("triangle v2 y coordinate not translated correctly", -15, t1.getV2().getY(),TOLERANCE);
    }

    @Test
    public void translateSimpleComposite() {
        pic1.translate(11, -5);
        //p1 = new PicPoint(3,0);
        assertEquals("composite element base x coordinate not translated correctly", 14, pic1.getComponents().get(1).getBase().getX(),TOLERANCE);
        assertEquals("composite element y coordinate not translated correctly", -5, pic1.getComponents().get(1).getBase().getY(),TOLERANCE);

    }

    @Test
    public void translateNestedComposite() {
        pic2.translate(15,17);
        Composite cmp = (Composite)pic2.getComponents().get(3);
        Picture pic = cmp.getComponents().get(2);
        // PicPoint p2A = new PicPoint(0,4);
        assertEquals("composite element base x coordinate not translated correctly", 15, pic.getBase().getX(),TOLERANCE);
        assertEquals("composite element y coordinate not translated correctly", 21, pic.getBase().getY(),TOLERANCE);


    }
}
