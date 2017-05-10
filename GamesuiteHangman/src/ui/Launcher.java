package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.*;

public class Launcher {
	public static void main(String[] args) {
		String naam = "";

		while (naam == null || naam.trim().isEmpty()) {
			naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		}

		Speler speler = new Speler(naam);
		/*PictionaryUI ui = new PictionaryUI(speler);
		// JOptionPane.showMessageDialog(null, "... zal binnekort spelen",
		// speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		ui.showMenu();*/
		WoordenLijst lijst = new WoordenLijst();
		WoordenLezer lezer = new WoordenLezer("hangman.txt");
		
		for (String woord : lezer.leesWoorden())
			lijst.voegToe(woord);
		
		System.out.println(lijst.getRandomWoord());
		HangManUI hangmanUI = new HangManUI(speler, lijst);
		hangmanUI.play();
	}
}