package ui;

import domain.*;

public class PicSpelUI {

	private Speler speler;
	private PictionaryWoordenLijst woordenlijst;
	private Pictionary spel;
	private PicSpelPaneel paneel;
	private PicSpelHoofdScherm scherm;
	
	public PicSpelUI(Speler speler, PictionaryWoordenLijst woordenlijst)
	{
		setSpeler(speler);
		setWoordenLijst(woordenlijst);
		createSpel();
	}
	
	private void createSpel()
	{
		spel = new Pictionary(speler, woordenlijst);
		paneel = new PicSpelPaneel(spel);
		scherm = new PicSpelHoofdScherm(spel, paneel);
	}
	
	private void setSpeler(Speler speler)
	{
		this.speler = speler;
	}
	
	private void setWoordenLijst(PictionaryWoordenLijst woordenlijst)
	{
		this.woordenlijst = woordenlijst;
	}
	
	public void play()
	{
		scherm.start();
	}
}
