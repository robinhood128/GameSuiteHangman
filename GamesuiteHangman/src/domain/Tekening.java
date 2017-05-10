package domain;

import java.util.ArrayList;

public class Tekening
{
	private ArrayList<Vorm> vormen;
	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	
	public Tekening(String naam)
	{
		vormen = new ArrayList<Vorm>();
		setNaam(naam);
	}

	public String getNaam() 
	{
		return naam;
	}

	private void setNaam(String naam) 
	{
		if (naam == null || naam.trim().isEmpty())
			throw new IllegalArgumentException("Slechte naam ingegeven.");
		this.naam = naam;
	}
	
	public void voegToe(Vorm vorm)
	{
		if (vorm == null)
			throw new DomainException("Vorm is null.");
		Omhullende o = vorm.getOmhullende();
		if (o.getLinkerBovenhoek().getX() < MIN_X || 
			o.getLinkerBovenhoek().getX() + o.getBreedte() > MAX_X ||
			o.getLinkerBovenhoek().getY() < MIN_Y ||
			o.getLinkerBovenhoek().getY() + o.getHoogte() > MAX_Y)
			throw new DomainException("Vorm is out of bounds.");
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index)
	{
		return vormen.get(index);
	}
	
	public int getAantalVormen()
	{
		return vormen.size();
	}
	
	public void verwijder(Vorm vorm)
	{
		vormen.remove(vorm);
	}
	
	public boolean bevat(Vorm vorm)
	{
		return vormen.contains(vorm);
	}
	
	public boolean equals(Object object)
	{
		if(!(object instanceof Tekening))
			return false;
		Tekening o = (Tekening)object;
		
		if (o.getAantalVormen() != getAantalVormen())
			return false;
		
		for(Vorm v : vormen)
			if (!o.bevat(v))
				return false;
		
		return true;
	}
	
	public String toString()
	{
		String result = "Tekening met naam " + naam + " bestaat uit " + getAantalVormen() + " vormen:";
		
		for(Vorm v : vormen)
			result += "\n" + v.toString();
		
		return result;
	}
}