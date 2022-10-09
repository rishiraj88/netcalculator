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
