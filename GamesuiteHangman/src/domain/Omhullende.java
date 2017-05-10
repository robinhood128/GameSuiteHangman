package domain;

public class Omhullende {

	private Punt positieLinksBoven;
	private int breedte, hoogte;

	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {

		setLinkerBovenhoek(positieLinksBoven);
		setBreedte(breedte);
		setHoogte(hoogte);

	}

	public Punt getLinkerBovenhoek() {
		return positieLinksBoven;
	}

	private void setLinkerBovenhoek(Punt positieLinksBoven) {
		if (positieLinksBoven == null) {
			throw new DomainException("Punt mag niet null zijn");
		}
		this.positieLinksBoven = positieLinksBoven;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte < 0) {
			throw new DomainException("Breedte moet groter of gelijk aan nul zijn.");
		}
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte < 0) {
			throw new DomainException("Hoogte moet groter of gelijk aan nul zijn");
		}
		this.hoogte = hoogte;
	}

	public int getMinimumX() {
		return positieLinksBoven.getX();
	}

	public int getMinimumY() {
		return positieLinksBoven.getY();
	}

	public int getMaximumX() {
		return positieLinksBoven.getX() + breedte;
	}

	public int getMaximumY() {
		return positieLinksBoven.getY() + hoogte;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Omhullende)) {
			return false;
		} else {
			Omhullende o = (Omhullende) object;
			if (o.positieLinksBoven.equals(positieLinksBoven) && o.getBreedte() == getBreedte()
					&& o.getHoogte() == getHoogte()) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String toString() {
		return "\nOmhullende: " + getLinkerBovenhoek() + " - " + getBreedte() + " - " + getHoogte();
	}
}
