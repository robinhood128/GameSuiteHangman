package domain;

public class HangMan 
{
	private Speler speler;
	
	public HangMan(Speler speler, WoordenLijst woordenlijst)
	{
		
	}
	
	public String getHint()
	{
		return "";
	}
	
	public Speler getSpeler()
	{
		return speler;
	}
	
	public TekeningHangMan getTekening()
	{
		return new TekeningHangMan(speler.getNaam());
	}
	
	public void raad(char letter)
	{
		
	}
	
	public boolean isGameOver()
	{
		return true;
	}
	
	public boolean isGewonnen()
	{
		return true;
	}
}