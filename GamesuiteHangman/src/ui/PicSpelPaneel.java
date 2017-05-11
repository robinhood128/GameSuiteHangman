package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;
import domain.Pictionary;

public class PicSpelPaneel extends JPanel {

	private static final long serialVersionUID = 1L;	
	
	private JTextField letter;	
	private JLabel woord;
	
	private TekenVenster tekenVenster;
	private Pictionary spel;
	
	public PicSpelPaneel(Pictionary spel2){
		super();
		setSpel(spel2);
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		woord = new JLabel("");
		
		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		woord.setText("Raden");
		getTekenVenster().teken();
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
				String input = letter.getText();
				spel.raad(input);

				letter.setText("");
				//getTekenVenster().teken();
				
				//TODO
				
				if (spel.isGewonnen())
				{
					JOptionPane.showMessageDialog(null, "U hebt gewonnen!");
					System.exit(0);
				}
				
				//toon boodschap als gewonnen of verloren en vraag of speler opnieuw wilt spelen
				//als de speler opnieuw wilt spelen: herzet het spel en het paneel
				//anders stop (System.exit(0))
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}
		@Override
		public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
	}
	
	private void setSpel(Pictionary spel){
		this.spel = spel;
	}

	private Pictionary getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
}