package qiwi.babich.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static qiwi.babich.parser.ParserTestData.*;

class CurrencyCodeAndDateParserTest {

    private static final CurrencyCodeAndDateParser CURRENCY_CODE_AND_DATE_PARSER = new CurrencyCodeAndDateParser();

    @Test
    void parseWithInvalidOptions() {
        assertThrows(RuntimeException.class, () -> CURRENCY_CODE_AND_DATE_PARSER.parse(new String[]{currencyCodeOption + validCurrencyCode,
                dateOption + validCurrencyDateString, illegalOption + illegalOptionValue}));
    }

    @Test
    void parseWithValidOptions() {
        CURRENCY_CODE_AND_DATE_PARSER.parse(new String[]{currencyCodeOption + validCurrencyCode, dateOption + validCurrencyDateString});
        assertEquals(CURRENCY_CODE_AND_DATE_PARSER.getCurrencyCode(), validCurrencyCode);
        assertEquals(CURRENCY_CODE_AND_DATE_PARSER.getRatesDate(), validCurrencyDateString);
    }

    @Test
    void parseWithoutRequiredArguments() {
        assertThrows(RuntimeException.class, () -> CURRENCY_CODE_AND_DATE_PARSER.parse(new String[]{currencyCodeOption + validCurrencyCode}));
    }
}
