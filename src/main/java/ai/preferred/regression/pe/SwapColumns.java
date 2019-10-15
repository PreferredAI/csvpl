/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
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
