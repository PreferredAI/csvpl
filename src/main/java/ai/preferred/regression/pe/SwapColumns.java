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
import java.util.Collections;

public class SwapColumns extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(SwapColumns.class);

  @Option(name = "-x", aliases = {"--column-x"}, usage = "the index of one column to be swapped", required = true)
  private int column1;

  @Option(name = "-y", aliases = {"--column-y"}, usage = "the index of the other column to be swapped", required = true)
  private int column2;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      final ArrayList<String> header = data.getHeader();
      Collections.swap(header, column1, column2);
      printer.printRecord(header);
    }

    for (final ArrayList<String> record : data) {
      Collections.swap(record, column1, column2);
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(SwapColumns.class, args);
  }

}
