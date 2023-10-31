package exception;

public class ApenasOsFortesException extends RuntimeException {

	public ApenasOsFortesException() {
		super("Você só pode duelar na arena a partir do LVL 10.");
		
	}

	public ApenasOsFortesException(String message) {
		super(message);
		
	}
	

}
