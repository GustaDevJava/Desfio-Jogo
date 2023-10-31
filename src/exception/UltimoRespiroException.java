package exception;

public class UltimoRespiroException extends RuntimeException {

	public UltimoRespiroException() {
		super("Você tem menos de 50 pontos de vida, caso lute novamente morrerá.");
		
	}

	public UltimoRespiroException(String message) {
		super(message);
		
	}

}
