package domain;

public class Speler {
	private String naam;
	private int score;

	public Speler(String naam) {
		setNaam(naam);
		score = 0;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty())
			throw new DomainException("Slechte spelersnaam.");
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public int getScore() {
		return score;
	}

	public void addToScore(int score) {
		if (this.score + score < 0)
			throw new DomainException("Score moet positief blijven.");
		this.score += score;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Speler))
			return false;
		else {
			Speler o = (Speler) object;
			return o.naam.equals(naam) && o.score == score;
		}
	}
}