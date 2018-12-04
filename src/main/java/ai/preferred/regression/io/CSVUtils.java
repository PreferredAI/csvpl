package ai.preferred.regression.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CSVUtils {

  public static CSVInputData reader(File file, boolean header) throws IOException {
    return new CSVInputData(file, header);
  }

  public static CSVPrinter printer(File file) throws IOException {
    return new CSVPrinter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8), CSVFormat.EXCEL);
  }

  @SafeVarargs
  public static <T> String[] toStringArray(T... values) {
    final String[] strings = new String[values.length];
    for (int i = 0; i < values.length; i++) {
      strings[i] = String.valueOf(values[i]);
    }
    return strings;
  }

  private CSVUtils() {
    throw new AssertionError();
  }

}
