package domain;

public class Lijnstuk extends Vorm{
	
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
	
	public boolean equals(Object object) {
		
		if(!(object instanceof Lijnstuk)) {
			return false;
		} else {
			Lijnstuk o = (Lijnstuk)object;
			return o.startPunt.equals(startPunt) && o.eindPunt.equals(eindPunt);
		}
	}
	
	@Override
	public String toString() {
		return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();
	}
	
}
