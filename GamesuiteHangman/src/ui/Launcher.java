package ui;

import db.WoordenLezer;
import domain.*;

public class Launcher {
	public static void main(String[] args) {
		try
		{
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
				PictionaryUI ui = new PictionaryUI(speler);
				ui.showMenu();
				break;
			}
		}
		
		catch (Exception e)
		{
			System.out.println("Closing application because of " + e.getMessage());
			System.exit(0);
		}
	}
}