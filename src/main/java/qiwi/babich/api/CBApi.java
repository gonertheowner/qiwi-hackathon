package qiwi.babich.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.net.HttpURLConnection.HTTP_OK;

public class CBApi {

    public static final String CBCurrencyDatePricesUrlString = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";

    public static String getCurrencyPrice(String code, String date, String apiUrlString) {
        String formattedDate = LocalDate.parse(date).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), value = null;
        try {
            URL url = new URL(apiUrlString + formattedDate);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            value = getValue(code, connection);
        } catch (IOException e) {
            throw new CBApiException(e.getMessage());
        }
        return value;
    }

    private static String getValue(String currencyCode, HttpURLConnection connection) throws IOException {
        if (connection.getResponseCode() == HTTP_OK) {
            return findCurrencyValue(connection.getInputStream(), currencyCode);
        } else {
            throw new CBApiException("Ошибка при получении курсов валют");
        }
    }

    private static String findCurrencyValue(InputStream is, String code) {
        try (Scanner scanner = new Scanner(is)) {
            if (scanner.hasNextLine()) {
                String[] currencies = scanner.nextLine().split("</Valute>");
                for (String currencyInfo : currencies) {
                    if (currencyInfo.contains("<CharCode>" + code + "</CharCode>")) {
                        return parseCurrencyValue(currencyInfo);
                    }
                }
            }
        }
        return null;
    }

    private static String parseCurrencyValue(String currencyInfo) {
        return currencyInfo.split("<Value>")[1].replace("</Value>", "");
    }
}
