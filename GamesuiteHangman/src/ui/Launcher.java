package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher 
{
	public static void main(String[] args) 
	{
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		PictionaryUI ui = new PictionaryUI(speler);
		//JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		ui.showMenu();
	}
}