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
import org.kohsuke.args4j.spi.StringArrayOptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectColumns extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectColumns.class);

  @Option(name = "-c", aliases = {"--columns"}, usage = "the column names separated by spaces", handler = StringArrayOptionHandler.class, required = true)
  private String[] columns = new String[0];

  private static List<Integer> indicesOf(ArrayList<String> header, String[] columns) {
    final List<Integer> indices = new ArrayList<>(columns.length);
    for (final String name : columns) {
      int index = header.indexOf(name);
      if (index > -1) {
        indices.add(index);
      }
    }
    return indices;
  }

  private static <T> ArrayList<T> projectIndices(ArrayList<T> list, List<Integer> indices) {
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
    final List<Integer> indices = indicesOf(header, columns);
    printer.printRecord(projectIndices(header, indices));

    for (final ArrayList<String> record : data) {
      printer.printRecord(projectIndices(record, indices));
    }

  }

  public static void main(String[] args) {
    parseArgsAndRun(ProjectColumns.class, args);
  }

}
