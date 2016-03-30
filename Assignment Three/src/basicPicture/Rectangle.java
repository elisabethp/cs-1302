package basicPicture;


/**
 * Represents a rectangle with sides parallel to the axes.
 * The 'base' point for a rectangle is its upper-left
 * corner.
 * Width and height are the horizontal and vertical dimensions
 * of the rectangle, respectively.
 */
public class Rectangle extends Geometric {
	
	private double width, height;

	public Rectangle(PicPoint base, double width, double height) {
		super(base);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return (width * 2) + (height * 2);
	}

	@Override
	public String toString() {
		return "line from (" + getBase().getX() + "," + getBase().getY() + ") to (" + (getBase().getX()+width) + "," + getBase().getY() + ")\n" +
				"line from (" + (getBase().getX()+width) + "," + getBase().getY() + ") to (" + (getBase().getX()+width) + "," + (getBase().getY()+height) + ")\n" +
				"line from (" + (getBase().getX()+width) + "," + (getBase().getY()+height) + ") to (" + getBase().getX() + "," + (getBase().getY()+height) + ")\n" +
				"line from (" + getBase().getX() + "," + (getBase().getY()+height) + ") to (" + getBase().getX() + "," + getBase().getY() + ")\n";

	}
}
