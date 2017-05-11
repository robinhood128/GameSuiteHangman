package ui;

import db.AfbeeldingshintLezer;
import db.WoordenLezer;
import domain.*;

public class Launcher {
	public static void main(String[] args) {
		String naam = InputDialogUtils.getInputString("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		Object[] multiplechoise = { "HangMan", "Pictionary" };
		
		switch((String)InputDialogUtils.getInputObject("Dag " + naam + ", welk spel wil je spelen?", multiplechoise))
		{
		case "HangMan":
			WoordenLijst lijst = new WoordenLijst();
			WoordenLezer lezer = new WoordenLezer("hangman.txt");
			
			for (String woord : lezer.leesWoorden())
			{
				lijst.voegToe(woord);
			}
			
			HangManUI hangmanUI = new HangManUI(speler, lijst);
			hangmanUI.play();
			break;
			
		case "Pictionary":
			PictionaryWoordenLijst lijst2 = new PictionaryWoordenLijst();
			AfbeeldingshintLezer lezer2 = new AfbeeldingshintLezer("pictionary.txt");
			
			for (PictionaryWoordEnTekening woord : lezer2.leesTekeningen())
			{
				lijst2.voegToe(woord);
			}
			
			PicSpelUI pictionary = new PicSpelUI(speler, lijst2);
			pictionary.play();
			break;
		}
	}
}