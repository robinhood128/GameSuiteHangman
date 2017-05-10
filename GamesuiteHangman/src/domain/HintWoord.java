package domain;

import java.util.ArrayList;

public class HintWoord {
	private String woord;
	private ArrayList<HintLetter> hintletters;
	private boolean isGeraden = false;

	public HintWoord(String woord) {
		hintletters = new ArrayList();
		setWoord(woord);
		setHintletters(woord);
	}

	public String getWoord() {
		return woord;
	}

	public void setWoord(String woord) {
		if (woord == null || woord.trim().toString().isEmpty()){
			throw new DomainException("Woord mag niet null of leeg zijn.");
		}
		this.woord = woord;
	}

	public ArrayList<HintLetter> getHintletters() {
		return hintletters;
	}

	public void setHintletters(String woord) {
		char[] charArray = woord.toCharArray();
		for (char h : charArray) {
			HintLetter b = new HintLetter(h);
			hintletters.add(b);
		}
	}

	public boolean raad(char letter) {
		boolean result = false;
		if (toString().indexOf(letter) > 0) {
			return false;
		}
		for (HintLetter h : hintletters) {
			if (h.raad(letter)){
				result = true;
			}

		}
		boolean allemaalgeraden = true;
		for (HintLetter h : hintletters) {
			
			if (!h.isGeraden()){
				allemaalgeraden = false;
			}

		}
		if (allemaalgeraden){
			isGeraden = true;
		}
		return result;
	}

	public boolean isGeraden() {
		return isGeraden;
	}

	public String toString() {
		// dummy
		String woordje = " ";
		for (HintLetter h : hintletters) {
			woordje += h.toChar() + " ";

		}
		return woordje.trim();
	}

}
