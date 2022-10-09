package sgs.tr.vat.service;

public interface TaxRateProviderService {
    public String provideVatRateByCountry(String countryIso);
}
