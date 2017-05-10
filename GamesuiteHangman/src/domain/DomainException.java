package domain;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DomainException(String string) {
		super(string);
	}

	public DomainException(String string, Exception exception) {
		super(string, exception);
	}
}