package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import ai.preferred.regression.io.CSVUtils;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AveragedColumn extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(AveragedColumn.class);

  @Option(name = "-c", aliases = {"--column"})
  private int column;

  @Option(name = "-d", aliases = {"--delimiter"})
  private String delimiter = ",";

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      ArrayList<String> header = data.getHeader();
      String colName = header.remove(column);
      header.add(colName);
      printer.printRecord(header);
    }

    for (ArrayList<String> record : data) {
      double sum = 0.0;
      int count = 0;
      for (String e: record.get(column).split(delimiter)) {
        sum += Double.parseDouble(e);
        count += 1;
      }
      record.remove(column);
      Collections.addAll(record, CSVUtils.toStringArray(sum/count));
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(AveragedColumn.class, args);
  }

}
