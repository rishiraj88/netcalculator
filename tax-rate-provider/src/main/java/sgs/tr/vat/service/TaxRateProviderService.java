package sgs.tr.vat.service;

public interface TaxRateProviderService {
    public Double provideVatRateByCountry(String countryIso);
}
