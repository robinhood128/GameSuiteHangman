package db;

public class DBException extends IllegalArgumentException{
	
	private static final long serialVersionUID = 1L;
	
	public DBException(String string) {
		super(string);
	}

	public DBException(String string, Exception exception) {
		super(string, exception);
	}
}
