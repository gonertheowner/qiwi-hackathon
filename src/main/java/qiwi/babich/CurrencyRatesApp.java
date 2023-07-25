package qiwi.babich;

import qiwi.babich.api.CBApi;
import qiwi.babich.parser.CurrencyCodeAndDateParser;

public class CurrencyRatesApp {

    public static void main(String[] args) {
        CurrencyCodeAndDateParser p = new CurrencyCodeAndDateParser();
        p.parse(args);
        CBApi api = new CBApi();
        api.getCurrencyPrice(p.getCurrencyCode().toUpperCase(), p.getRatesDate(), CBApi.CBCurrencyDatePricesUrlString);
    }
}
