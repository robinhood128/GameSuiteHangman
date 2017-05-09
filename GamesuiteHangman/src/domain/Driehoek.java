package domain;

public class Driehoek 
{
	private Punt punt1;
	private Punt punt2;
	private Punt punt3;
	
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
		setPunt1(hoekPunt1);
		setPunt2(hoekPunt2);
		setPunt3(hoekPunt3);
	}

	public Punt getPunt1() {
		return punt1;
	}

	public void setPunt1(Punt punt1) {
		this.punt1 = punt1;
	}

	public Punt getPunt2() {
		return punt2;
	}

	public void setPunt2(Punt punt2) {
		this.punt2 = punt2;
	}

	public Punt getPunt3() {
		return punt3;
	}

	public void setPunt3(Punt punt3) {
		this.punt3 = punt3;
	}
	
	public boolean equals(Object object)
	{
		if(!(object instanceof Driehoek))
			return false;
		Driehoek o = (Driehoek)object;
		return o.punt1.equals(punt1) && o.punt2.equals(punt2) && o.punt3.equals(punt3);
	}
	
	public String toString()
	{
		return "Driehoek: hoekpunt1: " + punt1.toString() + " hoekpunt2: " + punt2.toString() + " hoekpunt3: " + punt3.toString();
	}
}