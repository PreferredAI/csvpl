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
