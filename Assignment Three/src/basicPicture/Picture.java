package basicPicture;

public class Picture {
	private PicPoint base;

	public Picture(PicPoint base) {
		this.base = base;
	}

	public PicPoint getBase() {
		return base;
	}

	public void setBase(PicPoint base) {
		this.base = base;
	}

	public void translate(double dx, double dy) {
		base.setX(getBase().getX() + dx); //translate x value in base
		base.setY(getBase().getY() + dy); //translate y value in base
	}

	
	
}
