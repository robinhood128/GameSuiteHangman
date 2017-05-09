package domain;

import java.util.List;

public class Tekening extends Vorm
{
	private List<Vorm> vormen;
	private String naam;
	private int MIN_X;
	private int MIN_Y;
	private int MAX_X;
	private int MAX_Y;
	
	public tekening(String naam)
	{
		setNaam(naam);
	}

	public String getNaam() 
	{
		return naam;
	}

	public void setNaam(String naam) 
	{
		if (naam == null || naam.trim().isEmpty())
			throw new DomainException("Slechte naam ingegeven.");
		this.naam = naam;
	}
	
	public void voegToe(Vorm vorm)
	{
		
	}
}