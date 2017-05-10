package ui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import domain.Tekening;

public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening = null;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}

	private void setTekening(Tekening tekening) {
		if (tekening == null)
			throw new UIException("Tekening mag niet null zijn");
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		tekening.teken(graphics);
	}
}

/* Code voor een huis
Cirkel boomkruin = new Cirkel(new Punt(70, 70), 60);
Lijnstuk boomstam = new Lijnstuk(new Punt(70, 130), new Punt(70, 380));
Rechthoek gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
Driehoek dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
 */
