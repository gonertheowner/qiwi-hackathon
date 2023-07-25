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

    public String getCurrencyPrice(String code, String date, String apiUrlString) {
        try {
            String formattedDate = LocalDate.parse(date).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            URL url = new URL(apiUrlString + formattedDate);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HTTP_OK) {
                String value = findCurrencyValue(connection.getInputStream(), code);
                if (value == null) {
                    System.out.println("Ошибка при поиске заданной валюты");
                    return null;
                } else {
                    System.out.println(code + ": " + value);
                    return value;
                }
            } else {
                throw new RuntimeException("Ошибка при получении курсов валют");
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при отправке HTTP-запроса");
        }
    }

    private String findCurrencyValue(InputStream is, String code) {
        try (Scanner scanner = new Scanner(is)) {
            if (scanner.hasNextLine()) {
                String[] currencies = scanner.nextLine().split("</Valute>");
                for (String currency : currencies) {
                    if (currency.contains("<CharCode>" + code + "</CharCode>")) {
                        return parseCurrencyValue(currency);
                    }
                }
            }
        }
        return null;
    }

    private String parseCurrencyValue(String currencyInfo) {
        return currencyInfo.split("<Value>")[1].replace("</Value>", "");
    }
}
