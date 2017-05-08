package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Speler;

public class PictionaryUI {
private Speler speler;

public PictionaryUI(Speler speler) {
	this.speler = speler;
}

public void showMenu(){
	String xstring = JOptionPane.showInputDialog("x coordinaat van het punt:");
	String ystring = JOptionPane.showInputDialog("y coordinaat van het punt:");
int x = Integer.parseInt(xstring);
int y = Integer.parseInt(ystring);
Punt punt = new Punt(x,y);
JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt:" + punt.toString());

}

}
