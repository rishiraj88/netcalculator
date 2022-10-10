package gsg.nc.calc.service;

import org.springframework.stereotype.Service;

import gsg.nc.calc.exception.InvalidInputException;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

    /**
     * To calculate net price for a given pair of gross price and tax rate
     */
    @Override
    public double calculateNetPrice(double grossPrice, double taxRate) {
        // grossPrice = -1.2;
        if(0.0 > grossPrice) {
            throw new InvalidInputException("001","Gross price must not be negative.");
        }
        if(0.0 > taxRate) {
            throw new InvalidInputException("002","Tax rate may not be negative. Maybe government distribute subsidies via other means.");
        }
        return grossPrice * 1.0 / (1.0 + taxRate);
    }
    
}
