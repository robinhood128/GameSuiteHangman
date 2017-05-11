package domain;

public class HangMan 
{
	private Speler speler;
	private TekeningHangMan tekening;
	private WoordenLijst woordenlijst;
	private HintWoord hintwoord;
	
	public HangMan(Speler speler, WoordenLijst woordenlijst)
	{
		setSpeler(speler);
		setWoordenLijst(woordenlijst);
		this.woordenlijst = woordenlijst;
		tekening = new TekeningHangMan(speler.getNaam());
		hintwoord = new HintWoord(this.woordenlijst.getRandomWoord());
	}
	
	private void setSpeler(Speler speler)
	{
		if (speler == null)
			throw new DomainException("Speler is null.");
		this.speler = speler;
	}
	
	private void setWoordenLijst(WoordenLijst woordenlijst)
	{
		if (woordenlijst == null || woordenlijst.getAantalWoorden() == 0)
			throw new DomainException("Woordenlijst is leeg.");
		this.woordenlijst = woordenlijst;
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
			tekening.zetVolgendeZichtbaar();
		}
	}
	
	public String getWoord()
	{
		return hintwoord.getWoord();
	}
	
	public boolean isGameOver()
	{
		return tekening.getAantalOnzichtbaar() <= 0;
	}
	
	public boolean isGewonnen()
	{
		return hintwoord.isGeraden();
	}
}