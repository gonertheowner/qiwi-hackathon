package qiwi.babich;

import qiwi.babich.api.CBApi;
import qiwi.babich.parser.CurrencyCodeAndDateParser;
import qiwi.babich.parser.Parser;

import java.util.Map;

public class CurrencyRatesApp {

    public static void main(String[] args) {
        Parser p = new CurrencyCodeAndDateParser();
        p.parse(args);
        Map<String, String> parsedData = p.getParsedData();
        String code = parsedData.get("currencyCode").toUpperCase(), date = parsedData.get("ratesDate");
        String price = CBApi.getCurrencyPrice(code, date, CBApi.CBCurrencyDatePricesUrlString);
        System.out.println(code + ": " + price);
    }
}
