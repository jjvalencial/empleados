package co.com.empleados.app.exception;

public class BadRequestExceptions extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadRequestExceptions() {
		
	}
	
	public BadRequestExceptions(String message) {
		super(message);
		
	}

}
