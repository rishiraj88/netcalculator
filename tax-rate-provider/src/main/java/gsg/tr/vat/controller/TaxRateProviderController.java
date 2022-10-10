package gsg.tr.vat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gsg.tr.vat.service.TaxRateProviderService;


/**
 * /tr Initial context for Tax Rate Provider service
 */
@RestController
@RequestMapping("/tr")
public class TaxRateProviderController {

    @Autowired
    TaxRateProviderService taxRateProviderService;
    
    /**
     * To return the VAT rate applicable in the country identified by countryIso
     * @param countryIso Country code
     * @return Value added tax rate for the specified country
     */
    @GetMapping("/{land}")
    public ResponseEntity<Double> provideVatRateByCountry(@PathVariable("land") String countryIso) {
        return new ResponseEntity<Double>(taxRateProviderService.provideVatRateByCountry(countryIso),HttpStatus.OK);
    }

}
