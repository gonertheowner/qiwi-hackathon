package qiwi.babich.parser;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class CurrencyCodeAndDateParser implements Parser {

    @Option(name = "--code", required = true)
    private String currencyCode;

    @Option(name = "--date", required = true)
    private String ratesDate;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getRatesDate() {
        return ratesDate;
    }

    @Override
    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
