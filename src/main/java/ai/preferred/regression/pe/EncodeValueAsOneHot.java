package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import ai.preferred.regression.io.CSVUtils;
import ai.preferred.regression.pe.data.Vocabulary;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class EncodeValueAsOneHot extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(EncodeValueAsOneHot.class);

  @Option(name = "-c", aliases = {"--column"}, usage = "the index of the input column", required = true)
  private int column;

  @Option(name = "-p", aliases = {"--prefix"}, usage = "the prefix of the new columns")
  private String prefix = "VALUE:";

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    final Vocabulary vocabulary = buildVocabulary(data);

    if (data.hasHeader()) {
      final ArrayList<String> header = data.getHeader();
      header.remove(column);
      for (final String h : vocabulary.getVocabularyList()) {
        header.add(prefix + h);
      }
      printer.printRecord(header);
    }

    for (final ArrayList<String> record : data) {
      final Integer[] vOneHot = new Integer[vocabulary.size()];
      Arrays.fill(vOneHot, 0);
      final int index = vocabulary.getIndex(record.get(column));
      vOneHot[index] = 1;
      record.remove(column);
      Collections.addAll(record, CSVUtils.toStringArray(vOneHot));
      printer.printRecord(record);
    }
  }

  private Vocabulary buildVocabulary(CSVInputData reader) {
    final Set<String> vocabulary = new HashSet<>();
    for (final ArrayList<String> record : reader) {
      vocabulary.add(record.get(column));
    }

    return new Vocabulary(vocabulary);
  }

  public static void main(String[] args) {
    parseArgsAndRun(EncodeValueAsOneHot.class, args);
  }

}
