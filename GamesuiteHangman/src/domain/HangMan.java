package domain;

public class HangMan 
{
	private Speler speler;
	private TekeningHangMan tekening;
	private WoordenLijst woordenlijst;
	private HintWoord hintwoord;
	private int teller;
	
	public HangMan(Speler speler, WoordenLijst woordenlijst)
	{
		teller = 0;
		this.speler = speler;
		this.woordenlijst = woordenlijst;
		tekening = new TekeningHangMan(speler.getNaam());
		hintwoord = new HintWoord(this.woordenlijst.getRandomWoord());
	}
	
	public String getHint()
	{
		return hintwoord.toString();
	}
	
	public Speler getSpeler()
	{
		return speler;
	}
	
	public TekeningHangMan getTekening()
	{
		return tekening;
	}
	
	public void raad(char letter)
	{
		if (!hintwoord.raad(letter))
		{
			teller += 1;	
		}
	}
	
	public String getWoord()
	{
		return hintwoord.getWoord();
	}
	
	public boolean isGameOver()
	{
		return teller >= 14;
	}
	
	public boolean isGewonnen()
	{
		return hintwoord.isGeraden();
	}
}