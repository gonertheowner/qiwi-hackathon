package qiwi.babich.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static qiwi.babich.parser.ParserTestData.*;

class CurrencyCodeAndDateParserTest {

    private static final CurrencyCodeAndDateParser parser = new CurrencyCodeAndDateParser();

    @Test
    void parseWithInvalidOptions() {
        assertThrows(RuntimeException.class, () -> parser.parse(new String[]{currencyCodeOption + validCurrencyCode,
                dateOption + validCurrencyDateString, illegalOption + illegalOptionValue}));
    }

    @Test
    void parseWithValidOptions() {
        parser.parse(new String[]{currencyCodeOption + validCurrencyCode, dateOption + validCurrencyDateString});
        assertEquals(parser.getParsedData().get("currencyCode"), validCurrencyCode);
        assertEquals(parser.getParsedData().get("ratesDate"), validCurrencyDateString);
    }

    @Test
    void parseWithoutRequiredArguments() {
        assertThrows(RuntimeException.class, () -> parser.parse(new String[]{currencyCodeOption + validCurrencyCode}));
    }
}
