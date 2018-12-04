package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SelectEquals extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(SelectEquals.class);

  @Option(name = "-c", aliases = {"--column"}, usage = "the index of the input column", required = true)
  private int column;

  @Option(name = "-e", aliases = {"--equals"}, usage = "the value to be verified", required = true)
  private String value;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      printer.printRecord(data.getHeader());
    }

    for (final ArrayList<String> record : data) {
      if (value.equals(record.get(column))) {
        printer.printRecord(record);
      }
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(SelectEquals.class, args);
  }

}
