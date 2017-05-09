package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUI 
{
	private Speler speler;
	private Tekening tekening;

	public PictionaryUI(Speler speler) 
	{
		this.speler = speler;
	}
	
	public Speler getSpeler()
	{
		return speler;
	}
	
	public void start()
	{
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
	}
	
	public void showMenu()
	{
		tekening = new Tekening(JOptionPane.showInputDialog("Geef de naam van je tekening"));
		showNextCommand();
	}
	
	public void showNextCommand()
	{
		switch(Integer.parseInt(JOptionPane.showInputDialog("Wat wil je doen:\n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen")))
		{
		case 1:
			tekening.voegToe(showVormMenu());
			break;
		case 2:
			JOptionPane.showMessageDialog(null, tekening.toString());
			break;
		case 0:
			return;
		}
		
		showNextCommand();
	}
	
	public Vorm showVormMenu()
	{
		Object[] shapes = {"Cirkel", "Rechthoek", "Driehoek", "Lijnstuk"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		
		switch((String)keuze)
		{
		case "Cirkel":
			return showCirkelMenu();
		case "Rechthoek":
			return showRechthoekMenu();
		case "Driehoek":
			return showDriehoekMenu();
		case "Lijnstuk":
			return showLijnstukMenu();
		default:
			return null;
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
		Punt midden = showPuntMenu();
		String radiusstring = JOptionPane.showInputDialog("Radius van de cirkel:");
		int radius = Integer.parseInt(radiusstring);

		return new Cirkel(midden, radius);
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