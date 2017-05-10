package domain;

public abstract class Vorm implements Drawable {
	@Override
	public abstract boolean equals(Object object);

	@Override
	public abstract String toString();

	public abstract Omhullende getOmhullende();
}