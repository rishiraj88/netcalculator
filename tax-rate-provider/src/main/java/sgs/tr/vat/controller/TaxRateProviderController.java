package sgs.tr.vat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgs.tr.vat.service.TaxRateProviderService;

@RestController
@RequestMapping("/tr")
public class TaxRateProviderController {

    @Autowired
    TaxRateProviderService taxRateProviderService;
    
    @GetMapping("/{land}")
    public String provideVatRateByCountry(@PathVariable("land") String countryIso) {
        return taxRateProviderService.provideVatRateByCountry(countryIso);
    }

}
