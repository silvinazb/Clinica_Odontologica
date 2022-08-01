package finalBorrador.dh.borradorB.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> manejoErrorResourceNotFound(ResourceNotFoundException rnfe, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atención -> "+ rnfe.getMessage());
    }
}
