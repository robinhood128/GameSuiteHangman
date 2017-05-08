package domain;

public class LijnStuk {
	
	private int xstart, ystart, xeind, yeind;
	
	Punt startPunt = new Punt(xstart, ystart);
	Punt eindPunt = new Punt(xeind, yeind);
	
	public LijnStuk(Punt startPunt, Punt eindPunt) {
		
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
	
	public boolean equals(Object object) {
		return false;
		
	}
	
	public String toString() {
		return "";
	}
	
}
