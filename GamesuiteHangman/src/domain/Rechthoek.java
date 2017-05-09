package domain;

import java.awt.Graphics;

public class Rechthoek extends Vorm {
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;

	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	public void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if (linkerBovenhoek == null)
			throw new DomainException("Slecht punt.");
		this.linkerBovenhoek = linkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		if (breedte <= 0)
			throw new DomainException("Slechte breedte.");
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		if (hoogte <= 0)
			throw new DomainException("Slechte hoogte.");
		this.hoogte = hoogte;
	}

	public Omhullende getOmhullende() {
		return new Omhullende(linkerBovenhoek, breedte, hoogte);
	}

	public boolean equals(Object object) {
		if (!(object instanceof Rechthoek))
			return false;
		else {
			Rechthoek o = (Rechthoek) object;
			return o.linkerBovenhoek.equals(linkerBovenhoek) && o.breedte == breedte && o.hoogte == hoogte;
		}
	}

	public String toString() {
		return "Rechthoek: positie: " + linkerBovenhoek.toString() + " - breedte: " + breedte + " - hoogte: " + hoogte
				+ getOmhullende().toString();
	}

	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub

	}
}