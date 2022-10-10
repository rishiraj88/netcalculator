# netcalculator
Net Calculator service

For a company which provides financial services worldwide.

Develop with Java a service which allows consumers to calculate the net price from a gross price.

## Pseudo signature of calculation formula:
'''netPrice = calculateNetPrice(grossPrice, countryIso);'''

## Pseudo examples:
'''81 = calculateNetPrice(100, DE);
1.6 = calculateNetPrice(1.99, FR);'''

Your new service accesses taxRateProvider service which returns the current VAT required to calculate the net price for any given country. The tax data used by the taxRateProvider is represented as a simple map of the country to a tax rate.

## e.g.,
'''"DE":"0.19", // Germany has 19% VAT on standard taxable goods
"FR":"0.20", // France has 20% VAT on standard taxable goods
...'''

It is a fully runnable (with mvn) and testable Java implementation along with the instructions required for a reviewer.

## Projects and Components
- eureka: Eureka server for service discovery
- api-gateway: to welcome incoming requests for services
- net-calculator: to present the net price data to consumers
- tax-rate-provider: to retrieve VAT rate for specified country

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
Hit the following URLs with a web browser or a REST client:

http://localhost:8999/nc/de/129
http://localhost:8999/nc/fe/1.39

http://localhost:8999/tr/fr
http://localhost:8999/tr/de

The last two parts of URLs are:
de / fr : country codes
129 / 1.39 : gross prices

In response, respective net prices will be returned.

Try other values of country code and gross price for further use.

For any queries, feel free to utilise the contact points at:
https://rrshops.netlify.app/
