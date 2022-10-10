package gsg.nc.calc.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gsg.nc.calc.exception.InvalidInputException;

@ControllerAdvice
public class NetCalculatorControllerAdvice {
  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<String> handleInvalidInput(InvalidInputException exception) {
    return new ResponseEntity<String>("Please check the previously entered inputs and try again.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
    return new ResponseEntity<String>("Only these HTTP methods are supported: GET", HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<String> handleNumberFormatException(NumberFormatException exception) {
    return new ResponseEntity<String>("Gross price and tax rate must be in number format. For example, gross price = 100.00 and tax rate = 0.23 to signify 23% VAT rate.", HttpStatus.METHOD_NOT_ALLOWED);
  }

  // @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<String> handleIllegalStateException(IllegalStateException exception) {
    return new ResponseEntity<String>("We may add the tax rate for the requested country in future.", HttpStatus.NOT_FOUND);
  }

}
