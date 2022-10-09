package gsg.nc.calc.service;

import java.math.BigDecimal;

public interface NetCalculatorService {
    public BigDecimal calculateNetPrice(BigDecimal grossPrice, String countryIso);
}
