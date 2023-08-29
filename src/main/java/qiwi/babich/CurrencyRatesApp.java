package qiwi.babich;

import qiwi.babich.api.CBApi;
import qiwi.babich.parser.CurrencyCodeAndDateParser;
import qiwi.babich.parser.Parser;

public class CurrencyRatesApp {

    public static void main(String[] args) {
        Parser p = new CurrencyCodeAndDateParser();
        p.parse(args);
        String code = p.getParsedData().get("currencyCode").toUpperCase();
        String date = p.getParsedData().get("ratesDate");
        CBApi.getCurrencyPrice(code, date, CBApi.CBCurrencyDatePricesUrlString);
    }
}
