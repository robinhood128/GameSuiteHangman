package domain;

public abstract class Vorm {
	@Override
	public abstract boolean equals(Object object);

	@Override
	public abstract String toString();

	public abstract Omhullende getOmhullende();
}