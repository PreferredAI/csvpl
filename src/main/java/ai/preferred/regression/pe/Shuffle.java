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
import java.util.Random;

public class Shuffle extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(Shuffle.class);

  @Option(name = "-s", aliases = {"--seed"}, usage = "random seed")
  private long seed = 1;

  @Override
  protected void process(CSVInputData reader, CSVPrinter printer) throws IOException {
    if (reader.hasHeader()) {
      printer.printRecord(reader.getHeader());
    }

    final ArrayList<ArrayList<String>> data = reader.getRecords();
    Collections.shuffle(data, new Random(seed));
    printer.printRecords(data);
  }

  public static void main(String[] args) {
    parseArgsAndRun(Shuffle.class, args);
  }

}
