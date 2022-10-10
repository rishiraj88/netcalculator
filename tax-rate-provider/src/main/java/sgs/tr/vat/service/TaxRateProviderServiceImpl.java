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

    /**
     * To retrieve the prevalent VAT rate for the specified country
     * @param countryIso Country code
     * @return VAT rate
     */
    @Override
    public Double provideVatRateByCountry(String countryIso) {
        String vatRate = countryVatRates.get(countryIso.toUpperCase());
        if(null == countryVatRates.get(countryIso.toUpperCase())) {
            throw new VatRateNotFoundException("103", "VAT rate for the country "+ countryIso+" is not available.");
        }
        return Double.parseDouble(vatRate);
    }
    
}
