package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.StringArrayOptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class ProjectColumns extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectColumns.class);

  @Option(name = "-c", aliases = {"--columns"}, usage = "the column names separated by spaces", handler = StringArrayOptionHandler.class, required = true)
  private String[] columns = new String[0];

  private static Set<Integer> indicesOf(ArrayList<String> header, String[] columns) {
    final Set<Integer> indices = new LinkedHashSet<>();
    for (final String name : columns) {
      int index = header.indexOf(name);
      if (index > -1) {
        indices.add(index);
      }
    }
    return indices;
  }

  private static <T> ArrayList<T> projectIndices(ArrayList<T> list, Set<Integer> indices) {
    final ArrayList<T> projection = new ArrayList<>(indices.size());
    for (int index : indices) {
      projection.add(list.get(index));
    }
    return projection;
  }

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (!data.hasHeader()) {
      throw new IllegalArgumentException("ProjectColumns requires CSV with header!");
    }

    final ArrayList<String> header = data.getHeader();
    final Set<Integer> indices = indicesOf(header, columns);
    printer.printRecord(projectIndices(header, indices));

    for (final ArrayList<String> record : data) {
      printer.printRecord(projectIndices(record, indices));
    }

  }

  public static void main(String[] args) {
    parseArgsAndRun(ProjectColumns.class, args);
  }

}
