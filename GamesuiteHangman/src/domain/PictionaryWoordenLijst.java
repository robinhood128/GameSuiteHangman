package domain;

import java.util.ArrayList;
import java.util.Random;

public class PictionaryWoordenLijst {

	private ArrayList<PictionaryWoordEnTekening> woorden;
	
	public PictionaryWoordenLijst()
	{
		woorden = new ArrayList<PictionaryWoordEnTekening>();
	}
	
	public int getAantalWoorden()
	{
		return woorden.size();
	}
	
	public void voegToe(PictionaryWoordEnTekening string)
	{
		if (string == null)
			throw new DomainException("Foute string.");
		if (woorden.contains(string))
			throw new DomainException("Zit al in de lijst.");
		woorden.add(string);
	}
	public String getWoord(int index) {
		return woorden.get(index).getWoord();
	}
	public ArrayList<Vorm> getVormen(int index) {
		return woorden.get(index).getVormen();
	}
}
