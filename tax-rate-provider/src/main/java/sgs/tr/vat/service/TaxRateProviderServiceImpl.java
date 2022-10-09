package sgs.tr.vat.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TaxRateProviderServiceImpl implements TaxRateProviderService {

    private static Map<String,String> countryVatRates = new HashMap<>();

    static {
        countryVatRates.put("DE","0.19");
        countryVatRates.put("FR", "0.20");
        countryVatRates.put("IN","0.18");
        countryVatRates.put("ES", "0.23");
        countryVatRates.put("IT","0.16");
        countryVatRates.put("US", "0.06");
        countryVatRates.put("PT","0.21");
        countryVatRates.put("FN", "0.1675");   
    }

    @Override
    public String provideVatRateByCountry(String countryIso) {
        return countryVatRates.get(countryIso);
    }
    
}
