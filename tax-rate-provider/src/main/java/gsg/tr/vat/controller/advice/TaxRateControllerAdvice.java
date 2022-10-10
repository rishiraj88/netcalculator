package gsg.tr.vat.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gsg.tr.vat.exception.InvalidInputException;
import gsg.tr.vat.exception.VatRateNotFoundException;

@ControllerAdvice
public class TaxRateControllerAdvice {
  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<String> handleInvalidInput(InvalidInputException exception) {
    return new ResponseEntity<String>("Please check the entered inputs and try again.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
    return new ResponseEntity<String>("Only these HTTP methods are supported: GET", HttpStatus.METHOD_NOT_ALLOWED);
  }

  
  @ExceptionHandler(VatRateNotFoundException.class)
  public ResponseEntity<String> handleVatRateNotFoundException(VatRateNotFoundException exception) {
    return new ResponseEntity<String>("We may add the tax rate for the requested country soon.", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<String> handleNullPointerException(NullPointerException exception) {
    return new ResponseEntity<String>("Some data is missing. We'll try to fix on server side.", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<String> handleIllegalStateException(IllegalStateException exception) {
    return new ResponseEntity<String>("We may add support for the requested country in future.", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return new ResponseEntity<String>("Something unexpected has happened. We'll fix it soon.", HttpStatus.NOT_FOUND);
  }
}
