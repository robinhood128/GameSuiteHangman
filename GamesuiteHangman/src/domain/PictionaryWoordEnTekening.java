package domain;

import java.util.ArrayList;

public class PictionaryWoordEnTekening {
	public PictionaryWoordEnTekening(String woord, ArrayList<Vorm> vormen) {
		this.woord = woord;
		this.vormen = vormen;
	}
	private String woord;
	private ArrayList<Vorm> vormen;
	public String getWoord() {
		return woord;
	}
	public void setWoord(String woord) {
		this.woord = woord;
	}
	public ArrayList<Vorm> getVormen() {
		return vormen;
	}
	public void setVormen(ArrayList<Vorm> vormen) {
		this.vormen = vormen;
	}

	
}
