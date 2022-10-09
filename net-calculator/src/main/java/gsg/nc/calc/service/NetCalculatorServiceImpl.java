package gsg.nc.calc.service;

import org.springframework.stereotype.Service;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

    /**
     * To calculate net price for a given pair of gross price and tax rate
     */
    @Override
    public double calculateNetPrice(double grossPrice, double taxRate) {
        
        return grossPrice * 1.0 / (1.0 + taxRate);
    }
    
}
