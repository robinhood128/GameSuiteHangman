package ui;

public class UIException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;
	
	public UIException(String string) {
		super(string);
	}

	public UIException(String string, Exception exception) {
		super(string, exception);
	}
}