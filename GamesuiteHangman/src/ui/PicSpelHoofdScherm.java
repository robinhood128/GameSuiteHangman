package ui;

import java.awt.BorderLayout;

import domain.HangMan;
import domain.Pictionary;

public class PicSpelHoofdScherm extends GameHoofdScherm {

	private static final long serialVersionUID = 1L;
	
	public PicSpelHoofdScherm(Pictionary spel, PicSpelPaneel paneel){
		super("Pictionary - "+spel.getSpeler().getNaam(), spel.getTekening());	
		
		paneel.setTekenVenster(getTekenvenster());
		this.add(paneel, BorderLayout.SOUTH);
	}
	
	public void start() {
		this.pack();
		this.setVisible(true);		
	}
}
