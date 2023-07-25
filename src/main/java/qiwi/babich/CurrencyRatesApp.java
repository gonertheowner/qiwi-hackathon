package qiwi.babich;

public class CurrencyRatesApp {

    public static void main(String[] args) {
        Parser p = new Parser();
        p.parse(args);
        CBApi api = new CBApi();
        api.getCurrencyPrice(p.getCurrencyCode(), p.getRatesDate());
    }
}