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

public class AddX3 extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddX3.class);

  @Option(name = "-c", aliases = {"--column"}, usage = "the index of the column", required = true)
  private int column;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      ArrayList<String> header = data.getHeader();
      // TODO: transform this header here!
      // FOR EXAMPLE:
      // header.add("NEW_COLUMN");
      printer.printRecord(header);
    }

    for (final ArrayList<String> record : data) {
      // TODO: transform each record here!
      // FOR EXAMPLE:
      // record.add("VALUE");
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(AddX3.class, args);
  }

}
