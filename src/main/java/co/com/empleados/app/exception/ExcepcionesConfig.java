package co.com.empleados.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations=RestController.class)
public class ExcepcionesConfig {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?>notFountdException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(BadRequestExceptions.class)
	public ResponseEntity<?>badRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
