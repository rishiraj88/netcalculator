# Net Calculator
Net Calculator service (netcalculator) for any company which provides financial services across currencies, be it international or even worldwide. Developed with Java 17. It is a service which allows consumers to calculate the net price based on the input gross price and VAT (MWSt).

## Calculation formula:
The simplest interface for the net price formula expects two parameters from end users or integrated services:
- gross price
- ISO country code

The formula is listed below:
<pre>'''netPrice = calculateNetPrice(grossPrice, countryIso);'''</pre>

## Some Examples of the Usage of Net Price Formula:
'''81 = calculateNetPrice(100, DE);
1.6 = calculateNetPrice(1.99, FR);'''

This service accesses <pre>taxRateProvider</pre> service which returns the current VAT rate required to calculate the net price for a given country. The tax data used by the <pre>taxRateProvider</pre> is represented as a simple map of country code to tax rate.

## Some Examples of CountryCode To TaxRate:
- "DE":"0.19", // Germany has 19% VAT on standard taxable goods
- "FR":"0.20", // France has 20% VAT on standard taxable goods

It is a fully runnable (with mvn) and testable Java implementation along with the instructions required for a reviewer.

## Projects and Components
- `eureka`: Eureka server for service discovery
- `api-gateway`: to welcome incoming requests for services
- `net-calculator`: to present the net price data to consumers
- `tax-rate-provider`: to retrieve VAT rate for specified country

## Instructions for a Reviewer to Execute the Services

### Compile and Install Projects
- Inside eureka project directory: Run `mvn install`.
- Inside api-gateway project directory: Run `mvn install`.
- Inside net-calculator project directory: Run `mvn install`.
- Inside tax-rate-provider project directory: Run `mvn install`.

### Start Services
The services should be started in the following order to ensure smooth functioning:
- Start eureka project as a Java Application or Spring Boot App.
- Start api-gateway project as a Java Application or Spring Boot App.
- Start net-calculator project as a Java Application or Spring Boot App.
- Start tax-rate-provider project as a Java Application or Spring Boot App.

### Access the Services
Hit the following URLs with a modern web browser or a REST client:
- http://localhost:8999/nc/de/129
- http://localhost:8999/nc/fe/1.39
- http://localhost:8999/tr/fr
- http://localhost:8999/tr/de

The last two parts of URL paths signify the following semantics:
- `de` / `fr`: country codes
- `129` / `1.39`: gross prices

In response, respective net prices are be returned. You may try other values of country code and gross price as well.

## For any queries, feel free to utilise the contact points at:
- **LinkedIn:** <https://www.linkedin.com/in/rishirajopenminds>
- **X:** <https://twitter.com/RishiRajDevOps>
- **Start Page:** <https://bio.link/rishiraj49de>
- **GitHub:** <https://github.com/rishiraj88>
