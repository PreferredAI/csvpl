package ai.preferred.regression.io;

import weka.core.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ARFFDataReader {

  private static double parseDouble(ArrayList<String> record, int row, int col) throws IOException {
    try {
      return Double.parseDouble(record.get(col));
    } catch (NumberFormatException | NullPointerException e) {
      throw new IOException("A number expected! (row = " + row + "; col = " + col + ")");
    }
  }

  private final boolean nominal;
  private final boolean parseHeader;
  private final ArrayList<Attribute> signature;

  public ARFFDataReader(File signatureFile, boolean nominal, boolean parseHeader) throws IOException {
    this.nominal = nominal;
    this.parseHeader = parseHeader;
    try (final CSVInputData data = new CSVInputData(signatureFile, parseHeader)) {
      final ArrayList<Attribute> signature = new ArrayList<>();
      if (nominal) {
        final Set<String> attributeValueSet = new TreeSet<>();
        ArrayList<String> firstRecord = null;
        int row = parseHeader ? 1 : 0;
        for (final ArrayList<String> record : data) {
          if (firstRecord == null) {
            firstRecord = record;
          }
          attributeValueSet.add(record.get(0));
          for (int col = 1; col < record.size(); col++) {
            parseDouble(record, row, col);
          }
          row++;
        }
        if (firstRecord == null) {
          throw new IOException("There is no records in the CSV file!");
        }
        if (data.hasHeader()) {
          final ArrayList<String> header = data.getHeader();
          signature.add(new Attribute(header.get(0), new ArrayList<>(attributeValueSet)));
          for (int i = 1; i < header.size(); i++) {
            signature.add(new Attribute(header.get(i)));
          }
        } else {
          signature.add(new Attribute("Y", new ArrayList<>(attributeValueSet)));
          for (int i = 1; i < firstRecord.size(); i++) {
            signature.add(new Attribute("X" + i));
          }
        }
      } else {
        int row = parseHeader ? 1 : 0;
        if (data.hasHeader()) {
          final ArrayList<String> header = data.getHeader();
          signature.add(new Attribute(header.get(0)));
          for (int i = 1; i < header.size(); i++) {
            signature.add(new Attribute(header.get(i)));
          }
        }
        for (final ArrayList<String> record : data) {
          if (signature.isEmpty()) {
            signature.add(new Attribute("Y"));
            for (int i = 1; i < record.size(); i++) {
              signature.add(new Attribute("X" + i));
            }
          }
          for (int col = 0; col < record.size(); col++) {
            parseDouble(record, row, col);
          }
        }
        if (signature.isEmpty()) {
          throw new IOException("There is no records in the CSV file!");
        }
      }
      this.signature = signature;
    }
  }

  public ArrayList<Attribute> getSignature() {
    return new ArrayList<>(signature);
  }

  public Instances read(File file) throws IOException {
    final Instances instances = new Instances("DATA", signature, 100);
    instances.setClassIndex(0);
    try (final CSVInputData data = new CSVInputData(file, parseHeader)) {
      int row = parseHeader ? 1 : 0;
      for (final ArrayList<String> record : data) {
        final Instance instance = new DenseInstance(instances.numAttributes());
        for (int i = 1; i < record.size(); i++) {
          instance.setValue(i, parseDouble(record, row, i));
        }
        if (nominal) {
          instance.setValue(0, signature.get(0).indexOfValue(record.get(0)));
        } else {
          instance.setValue(0, parseDouble(record, row, 0));
        }
        instances.add(new SparseInstance(instance));
        row++;
      }
    }
    return instances;
  }

}
