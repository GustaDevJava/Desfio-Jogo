package exception;

public class ItemForaDoLimiteException extends RuntimeException {

	public ItemForaDoLimiteException() {
		super("Esse item está fora dos limites do inventário.");

	}

	public ItemForaDoLimiteException(String message) {
		super(message);

	}

}
