package gsg.nc.calc.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import gsg.nc.calc.exception.InvalidInputException;
import gsg.nc.calc.exception.VatRateNotFoundException;

@ControllerAdvice
public class NetCalculatorControllerAdvice {
  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<String> handleInvalidInput(InvalidInputException exception) {
    return new ResponseEntity<String>(exception.getEMessage()+"\nPlease check the entered inputs and try again.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
    return new ResponseEntity<String>("Only these HTTP methods are supported: GET", HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<String> handleNumberFormatException(NumberFormatException exception) {
    return new ResponseEntity<String>("Gross price must be in number format. For example, gross price = 100.00 is good.", HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(VatRateNotFoundException.class)
  public ResponseEntity<String> handleVatRateNotFoundException(VatRateNotFoundException exception) {
    return new ResponseEntity<String>("We may add the tax rate for the requested country soon.", HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<String> handleNullPointerException(NullPointerException exception) {
    return new ResponseEntity<String>("Some data is missing. We'll try to fix on server side.", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException exception) {
    return new ResponseEntity<String>("A resource is missing. We'll make it available soon.", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return new ResponseEntity<String>("We'll fix the following issue:\n\n"+exception.getMessage(), HttpStatus.NOT_FOUND);
  }

}
