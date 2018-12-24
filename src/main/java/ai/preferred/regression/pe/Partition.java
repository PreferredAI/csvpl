package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Partition extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(Partition.class);

  @Option(name = "-p", aliases = {"--proportion"}, usage = "the proportion of data to be selected or excluded (ranges from 0.0 to 1.0)")
  private double percent = 0.8;

  @Option(name = "-e", aliases = {"--exclude"}, usage = "takes the other half of the selection if specified")
  private boolean exclude = false;

  @Override
  protected void process(CSVInputData reader, CSVPrinter printer) throws IOException {
    if (reader.hasHeader()) {
      printer.printRecord(reader.getHeader());
    }

    final ArrayList<ArrayList<String>> data = reader.getRecords();
    final int n = (int) Math.round(percent * data.size());

    if (exclude) {
      printer.printRecords(data.subList(n, data.size()));
    } else {
      printer.printRecords(data.subList(0, n));
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(Partition.class, args);
  }

}
