package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class RemoveOversizedRows extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(RemoveOversizedRows.class);

  @Option(name = "-c", aliases = {"--column"})
  private int column;

  @Option(name = "-d", aliases = {"--delimiter"})
  private String delimiter = ",";

  @Option(name = "-l", aliases = {"--length"})
  private int maxLength;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      ArrayList<String> header = data.getHeader();
      printer.printRecord(header);
    }

    for (ArrayList<String> record : data) {
      if (record.get(column).split(delimiter).length <= maxLength) {
        printer.printRecord(record);
      }
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(RemoveOversizedRows.class, args);
  }

}
