package qiwi.babich.parser;

import java.util.Map;

public interface Parser {
    void parse(String[] args);

    Map<String, String> getParsedData();
}
