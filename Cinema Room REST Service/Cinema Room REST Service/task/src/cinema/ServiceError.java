package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ServiceError {

    @ExceptionHandler
    public ResponseEntity<Map<String,String>> handleAllException(SeatException e) {
        return new ResponseEntity<>(Map.of("error", e.getMessage()), e.httpStatus);
    }
}
