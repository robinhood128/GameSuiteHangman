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
	
	public void showMenu()
	{
		tekening = new Tekening(getInputString("Geef de naam van je tekening"));
		showNextCommand();
	}
	
	public void showNextCommand()
	{
		switch(getInputInteger("Wat wil je doen:\n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen"))
		{
		case 1:
			tekening.voegToe(showVormMenu());
			break;
		case 2:
			JOptionPane.showMessageDialog(null, tekening.toString());
			return;
		case 0:
			return;
		}
		
		showNextCommand();
	}
	
	public Vorm showVormMenu()
	{
		Object[] shapes = {"Cirkel", "Rechthoek", "Driehoek", "Lijnstuk"};
		Object keuze = getInputObject("Wat wilt u tekenen?", shapes);
		
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
		int x = getInputInteger("x coordinaat van het punt:");
		int y = getInputInteger("y coordinaat van het punt:");
		return new Punt(x,y);
	}
	
	public Cirkel showCirkelMenu()
	{
		Punt midden = showPuntMenu();
		int radius = getInputInteger("Radius van de cirkel:");
		return new Cirkel(midden, radius);
	}
	
	public Rechthoek showRechthoekMenu()
	{
		return new Rechthoek(showPuntMenu(), getInputInteger("Breedte van de rechthoek:"), getInputInteger("Lengte van de rechthoek:"));
	}
	
	public Driehoek showDriehoekMenu()
	{
		return new Driehoek(showPuntMenu(), showPuntMenu(), showPuntMenu());
	}
	
	public Lijnstuk showLijnstukMenu()
	{
		return new Lijnstuk(showPuntMenu(), showPuntMenu());
	}
	
	public String getInputString(String content)
	{
		String result = "";
		
		while(result == null || result.trim().isEmpty())
		{
			result = JOptionPane.showInputDialog(content);
		}
		
		return result;
	}
	
	public Object getInputObject(String content, Object ... multiplechoise)
	{
		Object result = null;
		
		while(result == null)
		{
			result = JOptionPane.showInputDialog(null, content, "input", JOptionPane.INFORMATION_MESSAGE, null, multiplechoise, null);
		}
		
		return result;
	}
	
	public int getInputInteger(String content)
	{
		int result = -1;
		
		while(result == -1)
		{
			try
			{
				result = Integer.parseInt(JOptionPane.showInputDialog(content));
			}
			
			catch (Exception e)
			{
				result = -1;
			}
		}
		
		return result;
	}
}