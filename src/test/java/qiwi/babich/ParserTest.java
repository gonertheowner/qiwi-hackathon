package qiwi.babich;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static qiwi.babich.ParserTestData.*;

class ParserTest {

    private static final Parser parser = new Parser();

    @Test
    void parseWithInvalidOptions() {
        assertThrows(RuntimeException.class, () -> parser.parse(new String[]{currencyCodeOption + validCurrencyCode,
                dateOption + validCurrencyDateString, illegalOption + illegalOptionValue}));
    }

    @Test
    void parseWithValidOptions() {
        parser.parse(new String[]{currencyCodeOption + validCurrencyCode, dateOption + validCurrencyDateString});
        assertEquals(parser.getCurrencyCode(), validCurrencyCode);
        assertEquals(parser.getRatesDate(), validCurrencyDateString);
    }

    @Test
    void parseWithoutRequiredArguments() {
        assertThrows(RuntimeException.class, () -> parser.parse(new String[]{currencyCodeOption + validCurrencyCode}));
    }
}
