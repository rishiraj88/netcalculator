package gsg.nc.calc.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gsg.nc.calc.service.NetCalculatorService;

@RestController
@RequestMapping("/nc")
public class NetCalculatorController {

    @Autowired
    private NetCalculatorService netCalculatorService;

    @GetMapping("/{land}/{gp}")
    public BigDecimal calculateNetPrice(@PathVariable("gp") String grossPrice, @PathVariable("land") String countryIso) {
        return netCalculatorService.calculateNetPrice(new BigDecimal(grossPrice),countryIso);
    }
}
