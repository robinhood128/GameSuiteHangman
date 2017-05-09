package domain;

public class Driehoek extends Vorm
{
	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3)
	{
		if (hoekPunt1 == null)
			throw new DomainException("Punt mag niet null zijn.");
		if (hoekPunt2 == null)
			throw new DomainException("Punt mag niet null zijn.");
		if (hoekPunt3 == null)
			throw new DomainException("Punt mag niet null zijn.");
		if (hoekPunt1.equals(hoekPunt2) || hoekPunt1.equals(hoekPunt3) || hoekPunt2.equals(hoekPunt3))
			throw new DomainException("Punten mogen niet samen vallen.");
		if ((hoekPunt2.getX() - hoekPunt1.getX()) * (hoekPunt3.getY() - hoekPunt1.getY()) == (hoekPunt3.getX() - hoekPunt1.getX()) * (hoekPunt2.getY() - hoekPunt1.getY()))
			throw new DomainException("Punten mogen niet op een lijn liggen.");
		setHoekPunt1(hoekPunt1);
		setHoekPunt2(hoekPunt2);
		setHoekPunt3(hoekPunt3);
	}
	
	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public void setHoekPunt1(Punt hoekPunt1) {
		this.hoekPunt1 = hoekPunt1;
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public void setHoekPunt2(Punt hoekPunt2) {
		this.hoekPunt2 = hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}

	public void setHoekPunt3(Punt hoekPunt3) {
		this.hoekPunt3 = hoekPunt3;
	}
	
	public boolean equals(Object object)
	{
		if(!(object instanceof Driehoek))
			return false;
		Driehoek o = (Driehoek)object;
		return o.hoekPunt1.equals(hoekPunt1) && o.hoekPunt2.equals(hoekPunt2) && o.hoekPunt3.equals(hoekPunt3);
	}
	
	public String toString()
	{
		return "Driehoek: hoekpunt1: " + hoekPunt1.toString() + " hoekpunt2: " + hoekPunt2.toString() + " hoekpunt3: " + hoekPunt3.toString();
	}
	
	public Omhullende getOmhullende(){
		int x1 = getHoekPunt1().getX();
		int x2 = getHoekPunt2().getX();
		int x3 = getHoekPunt3().getX();
		int y1= getHoekPunt1().getY();
		int y2 = getHoekPunt1().getY();
		int y3 = getHoekPunt1().getY();
	    int minx = Math.min(Math.min(x1, x2), x3);
	    int miny = Math.min(Math.min(y1, y2), y3);
	    int maxx = Math.max(Math.max(x1, x2), x3);
	    int maxy = Math.max(Math.max(y1, y2), y3);
	    Punt linksboven = new Punt(minx,miny);
	    int breedte = maxx-minx;
	    int hoogte = maxy-miny;
		return new Omhullende(linksboven,breedte,hoogte);

	}
}