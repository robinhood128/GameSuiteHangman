package domain;

import java.util.ArrayList;

public class Tekening extends Vorm
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

	public void setNaam(String naam) 
	{
		if (naam == null || naam.trim().isEmpty())
			throw new IllegalArgumentException("Slechte naam ingegeven.");
		this.naam = naam;
	}
	
	public void voegToe(Vorm vorm)
	{
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
}