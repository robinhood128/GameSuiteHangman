package ui;

import domain.Speler;
import domain.WoordenLijst;

public class HangManUI {

	private Speler speler;
	private WoordenLijst woordenlijst;
	
	public HangManUI(Speler speler, WoordenLijst woordenlijst)
	{
		setSpeler(speler);
		setWoordenLijst(woordenlijst);
	}
	
	private void setSpeler(Speler speler)
	{
		this.speler = speler;
	}
	
	private void setWoordenLijst(WoordenLijst woordenlijst)
	{
		this.woordenlijst = woordenlijst;
	}
	
	public void play()
	{
		
	}
}
