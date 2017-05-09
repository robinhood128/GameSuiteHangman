package domain;

public class Lijnstuk extends Vorm{
	
	private Punt startHoekPunt;
	private Punt eindHoekPunt;
	
	public Lijnstuk(Punt startPunt, Punt eindPunt) {
		
		setStartEnEindPunt(startPunt, eindPunt);
		
	}
	
	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
		
		if (startPunt == null || eindPunt == null) {
			throw new DomainException("Punten mogen niet leeg zijn");
		} else if (startPunt.equals(eindPunt)) {
			throw new DomainException("Punten mogen niet gelijk zijn aan elkaar");
		} else {
		this.startHoekPunt = startPunt;
		this.eindHoekPunt = eindPunt;
		}
	}	

	public Punt getStartPunt() {
		return startHoekPunt;
	}

	public Punt getEindPunt() {
		return eindHoekPunt;
	}	
	
	public boolean equals(Object object) {
		
		if(!(object instanceof Lijnstuk)) {
			return false;
		} else {
			Lijnstuk o = (Lijnstuk)object;
			return o.startHoekPunt.equals(startHoekPunt) && o.eindHoekPunt.equals(eindHoekPunt);
		}
	}
	
	@Override
	public String toString() {
		return "Lijn: startpunt: " + startHoekPunt.toString() + " - eindpunt: " + eindHoekPunt.toString();
	}
	
	
}
