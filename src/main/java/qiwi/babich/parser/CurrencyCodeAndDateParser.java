package qiwi.babich.parser;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.Map;

public class CurrencyCodeAndDateParser implements Parser {

    @Option(name = "--code", required = true)
    private String currencyCode;

    @Option(name = "--date", required = true)
    private String ratesDate;

    @Override
    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Map<String, String> getParsedData() {
        return Map.of("currencyCode", currencyCode, "ratesDate", ratesDate);
    }
}
