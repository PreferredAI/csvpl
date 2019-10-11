/*
 * Copyright 2019 Preferred.AI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AverageCell extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(AverageCell.class);

  @Option(name = "-c", aliases = {"--column"})
  private int column;

  @Option(name = "-d", aliases = {"--delimiter"})
  private String delimiter = ",";

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      ArrayList<String> header = data.getHeader();
      header.add(header.remove(column));
      printer.printRecord(header);
    }

    for (ArrayList<String> record : data) {
      double sum = 0.0;
      final String[] values = record.get(column).split(delimiter);
      for (final String v : values) {
        try {
          sum += Double.parseDouble(v.trim());
        } catch (NumberFormatException e) {
          LOGGER.error("Unable to parse the number", e);
        }
      }
      record.remove(column);
      record.add(String.valueOf(sum / values.length));
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(AverageCell.class, args);
  }

}
