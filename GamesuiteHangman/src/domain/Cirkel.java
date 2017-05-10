package domain;

public class Cirkel extends Vorm {

	private Punt middelPunt;
	private int radius;

	public Cirkel(Punt middelPunt, int radius) {
		setRadius(radius);
		setMiddelPunt(middelPunt);
	}

	public Cirkel() {
		this(new Punt(1, 1), 1);
	}

	public Punt getMiddelPunt() {
		return new Punt(middelPunt.getX(), this.middelPunt.getY());
	}

	public void setMiddelPunt(Punt middelPunt) {
		if (middelPunt == null) {
			throw new IllegalArgumentException("Het middelpunt mag niet leeg zijn.");
		}

		this.middelPunt = middelPunt;
	}

	public int getRadius() {
		return radius;
	}

	private void setRadius(int radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("De straal moet positief zijn.");
		}

		this.radius = radius;
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;

		if (o instanceof Cirkel) {
			if (this.getMiddelPunt().equals(((Cirkel) o).getMiddelPunt())
					&& this.getRadius() == ((Cirkel) o).getRadius())
				result = true;
		}

		return result;
	}

	@Override
	public String toString() {
		String resultaat;
		resultaat = "Cirkel: middelPunt: (" + middelPunt.getX() + " , " + middelPunt.getY() + ") - straal: "
				+ this.radius + getOmhullende().toString();
		return resultaat;
	}

	public Omhullende getOmhullende() {
		Punt midden = getMiddelPunt();
		int x = midden.getX() - getRadius();
		int y = midden.getY() - getRadius();
		Punt linksboven = new Punt(x, y);
		int lengte = getRadius() * 2;
		return new Omhullende(linksboven, lengte, lengte);
	}
}
