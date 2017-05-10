package domain;

import java.util.ArrayList;
import java.util.Random;

import db.WoordenLezer;

public class WoordenLijst {

	private ArrayList<String> woorden;
	
	public WoordenLijst()
	{
		WoordenLezer lezer = new WoordenLezer("hangman.txt");
		woorden = lezer.leesWoorden();
	}
	
	public int getAantalWoorden()
	{
		return woorden.size();
	}
	
	public void voegToe(String string)
	{
		if (string == null || string.trim().isEmpty())
			throw new DomainException("Foute string.");
		woorden.add(string);
	}
	
	public void getRandomWoord()
	{
		Random random = new Random();
		woorden.get(random.nextInt(getAantalWoorden()));
	}
}
