package domain;

import java.awt.Canvas;
import java.awt.Graphics;

public class TekenVenster extends Canvas
{
	private static final long serialVersionUID = 1L;
	private Tekening tekening;
	
	public TekenVenster(Tekening tekening)
	{
		setTekening(tekening);
	}

	public Tekening getTekening() 
	{
		return tekening;
	}

	public void setTekening(Tekening tekening) 
	{
		this.tekening = tekening;
	}
	
	public void paint(Graphics graphics)
	{
		
	}
	
	public void teken()
	{
		repaint();
	}
}