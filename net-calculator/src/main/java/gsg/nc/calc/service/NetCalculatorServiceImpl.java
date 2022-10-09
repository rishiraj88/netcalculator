package gsg.nc.calc.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

    @Override
    public BigDecimal calculateNetPrice(BigDecimal grossPrice, String countryIso) {
        double taxRate = 23.45;
        taxRate = 24.375;
        // double taxRate = taxRateProvider.getTaxRate("DE");
        
        BigDecimal multiplier = new BigDecimal(100.0/(100.0+taxRate));
        return grossPrice.multiply(multiplier);
    }
    
}
