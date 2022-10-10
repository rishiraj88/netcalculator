package gsg.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** To froward request flows to alternate paths if a service URL is not accessible
 *  Fault tolerance
 */
@RestController
public class FallbackController {
    /**
     * Alternate path for Net Calculator service (net price calculator) 
     * @return
     */
    @GetMapping("/ncFallback")
    public String netCalculatorFallbackHandling() {
        return "Net Calculator service is down at this moment. It will be again up in few minutes.";
    }

    /**
     * Alternate path for Tax Rate Provider service (VAT rate provider)
     * @return
     */
    @GetMapping("/trFallback")
    public String taxRateProviderFallbackHandling() {
        return "Tax Rate Provider service is down at this moment. It will be again up in few minutes.";
    }
}
