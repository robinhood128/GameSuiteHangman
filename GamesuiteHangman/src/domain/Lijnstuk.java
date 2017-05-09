package domain;

import java.awt.Graphics;

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
		return "Lijn: startpunt: " + startHoekPunt.toString() + " - eindpunt: " + eindHoekPunt.toString() + getOmhullende().toString();
	}
	
	public Omhullende getOmhullende(){
		int x1 = getStartPunt().getX();
		int x2 = getEindPunt().getX();
		int y1= getStartPunt().getY();
		int y2 = getEindPunt().getY();
	    int minx = Math.min(x1, x2);
	    int miny = Math.min(y1, y2);
	    int maxx = Math.max(x1, x2);
	    int maxy = Math.max(y1, y2);
	    Punt linksboven = new Punt(minx,miny);
	    int breedte = maxx-minx;
	    int hoogte = maxy-miny;
		return new Omhullende(linksboven,breedte,hoogte);
	}

	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}
	
}
