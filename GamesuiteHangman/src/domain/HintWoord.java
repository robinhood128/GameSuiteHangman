package domain;

import java.util.ArrayList;

public class HintWoord {
	private String woord;
	private ArrayList<HintLetter>hintletters;
	
	public HintWoord(String woord, ArrayList<HintLetter> hintletters) {
		setWoord(woord);
		setHintletters(hintletters);
	}

	public String getWoord() {
		return woord;
	}

	public void setWoord(String woord) {
		this.woord = woord;
	}

	public ArrayList<HintLetter> getHintletters() {
		return hintletters;
	}

	public void setHintletters(ArrayList<HintLetter> hintletters) {
		this.hintletters = hintletters;
	}
	
	public boolean raad(char letter){
		boolean result=false;
		for(HintLetter h:hintletters){
			if(h.equals(letter)){
				result=true;
			}
		}
		return result;
	}
	
	public boolean isGeraden(){
		
	}
	
	public String toString(){
		
	}
	
	public String getWoord(){
		
	}
}
