package gsg.nc.calc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gsg.nc.calc.exception.VatRateNotFoundException;
import gsg.nc.calc.service.NetCalculatorService;

/**
 * /nc Initial context for Net Calculator service
 */
@RestController
@RequestMapping("/nc")
public class NetCalculatorController {

    @Autowired
    private NetCalculatorService netCalculatorService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * To calculate the net price (the price before VAT) when gross price (= net price + VAT) and country code are available.
     * Tax rate (VAT rate) is derived from Tax Rate Provider service.
     * 
     * @param grossPrice the price including VAT
     * @param countryIso the ISO code of a country
     * @return netPrice the net price (= gross price - VAT)
     */
    @GetMapping("/{land}/{gp}")
    public ResponseEntity<Double> calculateNetPrice(@PathVariable("gp") Double grossPrice, @PathVariable("land") String countryIso) {

        // Communicating with Tax Rate Provider to get value added tax rate for specified country
        Double taxRate = this.restTemplate.getForObject("http://tax-rate-provider/tr/"+countryIso, Double.class);
        if(null == taxRate) {
            throw new VatRateNotFoundException("103", "VAT rate for the country "+ countryIso+" is not available.");
        }
        Double netPrice = netCalculatorService.calculateNetPrice(grossPrice,taxRate);
        //return netPrice;
        return new ResponseEntity<Double>(netPrice, HttpStatus.OK);
    }
}
