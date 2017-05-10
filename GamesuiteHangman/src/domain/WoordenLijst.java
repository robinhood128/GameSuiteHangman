package domain;

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {

	private ArrayList<String> woorden;
	
	public WoordenLijst()
	{
		woorden = new ArrayList<String>();
	}
	
	public int getAantalWoorden()
	{
		return woorden.size();
	}
	
	public void voegToe(String string)
	{
		if (string == null || string.trim().isEmpty())
			throw new DomainException("Foute string.");
		if (woorden.contains(string))
			throw new DomainException("Woord zit al in de woordenlijst.");
		woorden.add(string);
	}
	
	public String getRandomWoord()
	{
		Random random = new Random();
		return woorden.get(random.nextInt(getAantalWoorden()));
	}
}
