package domain;

public class Punt {
	private int x;
	private int y;

	public Punt(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Punt))
			return false;
		Punt o = (Punt) object;
		return o.getX() == x && o.getY() == y;
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

}
