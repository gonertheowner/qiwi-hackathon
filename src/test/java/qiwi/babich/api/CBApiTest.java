package qiwi.babich.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static qiwi.babich.api.CBApiTestData.illegalApiUrlString;
import static qiwi.babich.api.CBApiTestData.legalApiUrlString;
import static qiwi.babich.parser.ParserTestData.*;

class CBApiTest {

    private static final CBApi api = new CBApi();

    @Test
    void getCurrencyPriceIllegalCurrencyCode() {
        assertNull(api.getCurrencyPrice(invalidCurrencyCode, validCurrencyDateString, legalApiUrlString));
    }

    @Test
    void getCurrencyPriceIllegalDate() {
        assertNull(api.getCurrencyPrice(validCurrencyCode, invalidCurrencyDateString, legalApiUrlString));
    }

    @Test
    void getCurrencyPriceIllegalApiUrl() {
        assertThrows(RuntimeException.class, () ->
                api.getCurrencyPrice(validCurrencyCode, validCurrencyDateString, illegalApiUrlString));
    }

    @Test
    void getCurrencyPriceWithLegalDataAndApiUrl() {
        assertNotNull(api.getCurrencyPrice(validCurrencyCode, validCurrencyDateString, legalApiUrlString));
    }
}
