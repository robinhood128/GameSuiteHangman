package domain;

public class Lijnstuk extends Vorm {

	private Punt startPunt;
	private Punt eindPunt;

	public Lijnstuk(Punt startPunt, Punt eindPunt) {

		setStartEnEindPunt(startPunt, eindPunt);

	}

	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {

		if (startPunt == null || eindPunt == null) {
			throw new DomainException("Punten mogen niet leeg zijn");
		} else if (startPunt.equals(eindPunt)) {
			throw new DomainException("Punten mogen niet gelijk zijn aan elkaar");
		} else {
			this.startPunt = startPunt;
			this.eindPunt = eindPunt;
		}
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Lijnstuk)) {
			return false;
		} else {
			Lijnstuk o = (Lijnstuk) object;
			return o.startPunt.equals(startPunt) && o.eindPunt.equals(eindPunt);
		}
	}

	@Override
	public String toString() {
		return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString()
				+ getOmhullende().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		int x1 = getStartPunt().getX();
		int x2 = getEindPunt().getX();
		int y1 = getStartPunt().getY();
		int y2 = getEindPunt().getY();
		int minx = Math.min(x1, x2);
		int miny = Math.min(y1, y2);
		int maxx = Math.max(x1, x2);
		int maxy = Math.max(y1, y2);
		Punt linksboven = new Punt(minx, miny);
		int breedte = maxx - minx;
		int hoogte = maxy - miny;
		return new Omhullende(linksboven, breedte, hoogte);
	}
}
