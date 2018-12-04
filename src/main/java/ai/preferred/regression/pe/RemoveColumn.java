package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class RemoveColumn extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(RemoveColumn.class);

  @Option(name = "-c", aliases = {"--column"}, usage = "the index of the column to be dropped", required = true)
  private int column;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      final ArrayList header = data.getHeader();
      header.remove(column);
      printer.printRecord(header);
    }

    for (final ArrayList<String> record : data) {
      record.remove(column);
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(RemoveColumn.class, args);
  }

}
