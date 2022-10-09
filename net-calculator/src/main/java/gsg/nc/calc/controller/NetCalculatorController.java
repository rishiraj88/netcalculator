package gsg.nc.calc.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gsg.nc.calc.service.NetCalculatorService;

@RestController
@RequestMapping("/nc")
public class NetCalculatorController {

    @Autowired
    private NetCalculatorService netCalculatorService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{land}/{gp}")
    public double calculateNetPrice(@PathVariable("gp") String grossPrice, @PathVariable("land") String countryIso) {

        String taxRate = this.restTemplate.getForObject("http://tax-rate-provider/tr/"+countryIso, String.class);

        return netCalculatorService.calculateNetPrice(Double.parseDouble(grossPrice),taxRate);
    }
}
