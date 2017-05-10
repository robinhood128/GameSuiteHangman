package domain;

public class HintLetter {
	private char letter;
	private boolean isGeraden = false;

	public HintLetter(char letter) {
		this.letter = letter;
	}
	
	public boolean raad(char letter){
		if ((Character.toLowerCase(letter) == getLetter()||Character.toUpperCase(letter) == getLetter()||letter == getLetter())& !isGeraden()){
			isGeraden = true;
			return true;
		}
		return false;
	}

	public boolean isGeraden() {
		return isGeraden;
	}

	public char getLetter() {
		return letter;
	}
	
	public char toChar(){
		if (isGeraden()){
			return getLetter();
		}
		return '_';
	}

}
