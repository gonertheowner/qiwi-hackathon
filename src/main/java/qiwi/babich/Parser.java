package qiwi.babich;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Parser {

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

    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
