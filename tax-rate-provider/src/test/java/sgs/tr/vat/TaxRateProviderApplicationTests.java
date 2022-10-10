package sgs.tr.vat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gsg.tr.vat.service.TaxRateProviderService;
import gsg.tr.vat.service.TaxRateProviderServiceImpl;


@SpringBootTest(classes = {TaxRateProviderServiceImpl.class})
class TaxRateProviderApplicationTests {

	@Autowired
	TaxRateProviderService taxRateProviderService;

	@Test
	public void getValidVatRate() {
		when(taxRateProviderService.provideVatRateByCountry("")).thenReturn
	}

}
