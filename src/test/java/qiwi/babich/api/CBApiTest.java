package qiwi.babich.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static qiwi.babich.api.CBApiTestData.*;
import static qiwi.babich.parser.ParserTestData.*;

class CBApiTest {

    @Test
    void getCurrencyPriceHappyPath() {
        assertEquals(CBApi.getCurrencyPrice(validCurrencyCode, validCurrencyDateString, legalApiUrlString), validCurrencyPriceString);
    }

    @Test
    void getCurrencyPriceIllegalCurrencyCode() {
        assertNull(CBApi.getCurrencyPrice(invalidCurrencyCode, validCurrencyDateString, legalApiUrlString));
    }

    @Test
    void getCurrencyPriceIllegalDate() {
        assertNull(CBApi.getCurrencyPrice(validCurrencyCode, invalidCurrencyDateString, legalApiUrlString));
    }

    @Test
    void getCurrencyPriceIllegalApiUrl() {
        assertThrows(RuntimeException.class, () -> CBApi.getCurrencyPrice(validCurrencyCode, validCurrencyDateString, illegalApiUrlString));
    }
}
