package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AddX2 extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddX2.class);

  @Option(name = "-c", aliases = {"--column"}, usage = "the index of the column", required = true)
  private int column;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      final ArrayList<String> header = data.getHeader();
      header.add("(" + header.get(column) + ")^2");
      printer.printRecord(header);
    }

    for (final ArrayList<String> record : data) {
      final String value = record.get(column);
      final double x = Double.parseDouble(value);
      final double x2 = x * x;
      record.add(String.valueOf(x2));
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(AddX2.class, args);
  }

}
