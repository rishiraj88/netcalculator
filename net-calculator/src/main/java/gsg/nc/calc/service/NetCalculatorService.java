package gsg.nc.calc.service;

import java.math.BigDecimal;

public interface NetCalculatorService {
    public double calculateNetPrice(double grossPrice, String countryIso);
}
