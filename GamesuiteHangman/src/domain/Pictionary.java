package domain;

import java.util.concurrent.ThreadLocalRandom;

public class Pictionary 
{
	private Speler speler;
	private PictionaryWoordenLijst woordenlijst;
	private int random;
	private boolean isGewonnen;
	private String woord;
	
	public Pictionary(Speler speler, PictionaryWoordenLijst woordenlijst)
	{
		setSpeler(speler);
		this.woordenlijst = woordenlijst;
		int random = ThreadLocalRandom.current().nextInt(0, woordenlijst.getAantalWoorden()-1);
		this.woord = woordenlijst.getWoord(random);
		isGewonnen = false;
	}
	
	private void setSpeler(Speler speler)
	{
		if (speler == null)
			throw new DomainException("Speler is null.");
		this.speler = speler;
	}
	
	private void setWoordenLijst(PictionaryWoordenLijst woordenlijst)
	{
		if (woordenlijst == null || woordenlijst.getAantalWoorden() == 0)
			throw new DomainException("Woordenlijst is leeg.");
		this.woordenlijst = woordenlijst;
	}
	
	public String getWoord()
	{
		return woord;
	}
	
	public Speler getSpeler()
	{
		return speler;
	}
	
	public Tekening getTekening()
	{
		Tekening tekening = new Tekening(woord);
		for (Vorm h : woordenlijst.getVormen(random)) {
			tekening.voegToe(h);
		}
		return tekening;
	}
	
	public void raad(String gok)
	{
		if (woord.equals(gok)){
			isGewonnen = true;
		}
	}
		
	public boolean isGewonnen()
	{
		return isGewonnen;
	}
}