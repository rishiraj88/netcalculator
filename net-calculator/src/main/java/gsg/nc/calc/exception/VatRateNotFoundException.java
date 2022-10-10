package gsg.nc.calc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VatRateNotFoundException extends RuntimeException {
  private String eCode;
  private String eMessage;
}
