package domain;

public abstract class Vorm 
{
	public boolean equals(Object object)
	{
		if(!(object instanceof Vorm))
			return false;
		return this == object;
	}
}