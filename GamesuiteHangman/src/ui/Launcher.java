package ui;

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
				System.out.println(woord);
				lijst.voegToe(woord);
			}
			
			HangManUI hangmanUI = new HangManUI(speler, lijst);
			hangmanUI.play();
			break;
			
		case "Pictionary":
			PictionaryUI ui = new PictionaryUI(speler);
			ui.showMenu();
			break;
		}
	}
}