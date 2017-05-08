package domain;

public class Speler 
{
	public String naam;
	public int score;
	
	public Speler(String naam)
	{
		this.naam = naam;
		score = 0;
	}
	
	public String getNaam()
	{
		return naam;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void addToScore(int score)
	{
		this.score += score;
	}
	
	public boolean equals(Object object)
	{
		if(!(object instanceof Speler))
			return false;
		else
			return ((Speler)object).naam == naam;
	}
}