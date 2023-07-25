package qiwi.babich.parser;

public class ParserTestData {

    public static final String validCurrencyCode = "USD";
    public static final String validCurrencyDateString = "2022-10-08";
    public static final String invalidCurrencyCode = "invalid code";
    public static final String invalidCurrencyDateString = "5000-01-01";
    public static final String currencyCodeOption = "--code=";
    public static final String dateOption = "--date=";
    public static final String illegalOption = "--get-free-money=";
    public static final Integer illegalOptionValue = 1_000_000;
}
