package gsg.nc.calc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidInputException extends RuntimeException {

  private String eCode;
  private String eMessage;


}
