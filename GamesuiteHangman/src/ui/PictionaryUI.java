package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUI 
{
	private Speler speler;

	public PictionaryUI(Speler speler) 
	{
		this.speler = speler;
	}
	
	public Speler getSpeler()
	{
		return speler;
	}
	
	public void showMenu()
	{
		Object[] shapes = {"Cirkel", "Rechthoek", "Driehoek", "Lijnstuk"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		switch((String)keuze)
		{
		case "Cirkel":
			showCirkelMenu();
			break;
		case "Rechthoek":
			showRechthoekMenu();
			break;
		case "Driehoek":
			showDriehoekMenu();
			break;
		case "Lijnstuk":
			showLijnstukMenu();
			break;
		}
	}
	
	public Punt showPuntMenu()
	{
		String xstring = JOptionPane.showInputDialog("x coordinaat van het punt:");
		String ystring = JOptionPane.showInputDialog("y coordinaat van het punt:");
		int x = Integer.parseInt(xstring);
		int y = Integer.parseInt(ystring);
		return new Punt(x,y);
	}
	
	public Cirkel showCirkelMenu()
	{
		return null;
	}
	
	public Rechthoek showRechthoekMenu()
	{
		return new Rechthoek(showPuntMenu(), Integer.parseInt(JOptionPane.showInputDialog("Breedte van de rechthoek:")), Integer.parseInt(JOptionPane.showInputDialog("Lengte van de rechthoek:")));
	}
	
	public Driehoek showDriehoekMenu()
	{
		return new Driehoek(showPuntMenu(), showPuntMenu(), showPuntMenu());
	}
	
	public Lijnstuk showLijnstukMenu()
	{
		return new Lijnstuk(showPuntMenu(), showPuntMenu());
	}
}