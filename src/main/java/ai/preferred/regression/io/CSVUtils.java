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
