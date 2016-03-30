package basicPicture;

public class Triangle extends Geometric {

	private PicPoint v1, v2;

	public Triangle(PicPoint v0, PicPoint v1, PicPoint v2) {
		super(v0);
		this.v1 = v1;
		this.v2 = v2;
	}

	public PicPoint getV1() {
		return v1;
	}

	public void setV1(PicPoint v1) {
		this.v1 = v1;
	}

	public PicPoint getV2() {
		return v2;
	}

	public void setV2(PicPoint v2) {
		this.v2 = v2;
	}


	@Override
	public double getArea() {
		double firstPart = getBase().getX() * (v1.getY() - v2.getY());
		double secondPart = v1.getX() * (v2.getY() - getBase().getY());
		double thirdPart = v2.getX() * (getBase().getY() - v1.getY());

		return Math.abs((firstPart + secondPart + thirdPart) / 2);
	}

	public double getPerimeter() {
		double firstSide = getBase().distance(v2);
		double secondSide = v2.distance(v1);
		double thirdSide = v1.distance(getBase());

		return firstSide + secondSide + thirdSide;
	}

	public void translate(double dx, double dy) {
		super.translate(dx, dy);

		getV1().setX(getV1().getX() + dx); //translates v1's x-value
		getV1().setY(getV1().getY() + dy); //translates v1's y-value

		getV2().setX(getV2().getX() + dx); //translates v2's x-value
		getV2().setY(getV2().getY() + dy); //translates v2's y-value

	}

	@Override
	public String toString() {
		return "line from (" + getBase().getX() + "," + getBase().getY() + ") to (" + getV1().getX() + "," + getV1().getY() + ")\n" +
				"line from (" + getV1().getX() + "," + getV1().getY() + ") to (" + getV2().getX() + "," + getV2().getY() + ")\n" +
				"line from (" + getV2().getX() + "," + getV2().getY() + ") to (" + getBase().getX() + "," + getBase().getY() + ")\n";

	}

}
