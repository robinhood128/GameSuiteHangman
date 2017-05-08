package domain;

public class Cirkel {
	
	private Punt middelPunt;
	private int radius;
	
	public Cirkel(Punt middelPunt, int radius) {
		if (radius<=0){
			throw new IllegalArgumentException("De straal moet positief zijn.");
		}
		if(middelPunt==null||middelPunt.getX()<radius||middelPunt.getY()<radius){
			throw new IllegalArgumentException();
		}
		this.radius = radius;
		this.setMiddelPunt(middelPunt);
	}
	
	public Cirkel() {
		this.middelPunt=new Punt(1,1);
		this.radius = 1;
	}

	public Punt getMiddelPunt() {
		return new Punt(middelPunt.getX(),this.middelPunt.getY());
	}
	
	private void setMiddelPunt(Punt middelPunt){
		if (middelPunt==null){
			throw new IllegalArgumentException("Het middelpunt mag niet leeg zijn.");
		}
		
		this.middelPunt=middelPunt;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString(){
		String resultaat;
		resultaat="Middelpunt = ("+middelPunt.getX()+" , "+middelPunt.getY()+") en straal = "+this.radius;
		return resultaat;
	}
}
