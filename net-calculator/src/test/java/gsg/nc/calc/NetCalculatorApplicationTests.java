package gsg.nc.calc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gsg.nc.calc.service.NetCalculatorService;

@SpringBootTest
class NetCalculatorApplicationTests {

	@Autowired
	NetCalculatorService netCalculatorService;
	
	@Test
	void contextLoads() {
	}

}
