package gsg.nc.calc.service;

import org.springframework.stereotype.Service;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

    @Override
    public double calculateNetPrice(double grossPrice, String taxRate) {
        // taxRate = "0.2345";
        // taxRate = "0.24375";

        return grossPrice * 1.0 / (1.0 + Double.parseDouble(taxRate));
    }
    
}
