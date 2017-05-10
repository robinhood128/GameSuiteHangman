package ui;

import javax.swing.JOptionPane;

import domain.*;

public class HangManUI {

	private Speler speler;
	private WoordenLijst woordenlijst;
	private HangMan spel;
	private HangmanPaneel paneel;
	private HangManHoofdScherm scherm;
	
	public HangManUI(Speler speler, WoordenLijst woordenlijst)
	{
		setSpeler(speler);
		setWoordenLijst(woordenlijst);
		createSpel();
	}
	
	private void createSpel()
	{
		spel = new HangMan(speler, woordenlijst);
		paneel = new HangmanPaneel(spel);
		scherm = new HangManHoofdScherm(spel, paneel);
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
		scherm.start();
	}
}
