package basicPicture;

import java.util.ArrayList;

/**
 * Created by Elisabeth on 2/14/2016.
 */

public class Composite extends Picture {

    private ArrayList<Picture> components = new ArrayList<>();

    public Composite() {
        super(new PicPoint(Double.NaN, Double.NaN));
    }

    public ArrayList<Picture> getComponents() {
        return components;
    }

    public void translate(double dx, double dy) {
        for (Picture g : components) {
            g.translate(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < components.size(); i++) {
            finalString.append(components.get(i));
        }

        return finalString.toString();
    }
}
