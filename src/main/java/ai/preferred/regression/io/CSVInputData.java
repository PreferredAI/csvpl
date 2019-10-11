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

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVInputData implements Iterable<ArrayList<String>>, AutoCloseable {

  private final ArrayList<String> header;
  private final boolean parseHeader;
  private final File file;

  public CSVInputData(File file, boolean parseHeader) throws IOException {
    this.file = file;
    this.parseHeader = parseHeader;
    if (parseHeader) {
      header = parseHeader();
    } else {
      header = null;
    }
  }

  private ArrayList<String> parseHeader() throws IOException {
    final CSVParser parser = newParser();
    final Iterator<CSVRecord> iterator = parser.iterator();
    if (!iterator.hasNext()) {
      throw new IOException("The header record is not found!");
    }
    CSVRecord headerRecord = iterator.next();
    parser.close();
    return Lists.newArrayList(headerRecord);
  }

  public boolean hasHeader() {
    return header != null;
  }

  public ArrayList<String> getHeader() {
    if (header == null) {
      throw new UnsupportedOperationException("This CSV file has no header!");
    }
    return new ArrayList<>(header);
  }

  public ArrayList<ArrayList<String>> getRecords() throws IOException {
    final CSVParser parser = newParser();
    final Iterator<CSVRecord> iterator = parser.iterator();
    final ArrayList<ArrayList<String>> data = new ArrayList<>();
    skipHeaderIfExists(iterator);
    while (iterator.hasNext()) {
      data.add(Lists.newArrayList(iterator.next()));
    }
    parser.close();
    return data;
  }

  private void skipHeaderIfExists(Iterator<CSVRecord> iterator) throws IOException {
    if (parseHeader) {
      if (!iterator.hasNext()) {
        throw new IOException("The header record is not found!");
      }
      iterator.next();
    }
  }

  @Override
  public Iterator<ArrayList<String>> iterator() {
    try {
      return new Iter();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private CSVParser newParser() throws IOException {
    return CSVParser.parse(file, StandardCharsets.UTF_8, CSVFormat.EXCEL);
  }

  @Override
  public void close() {
    // do nothing
  }

  private class Iter implements Iterator<ArrayList<String>>, Closeable {

    private final CSVParser parser;
    private final Iterator<CSVRecord> innerIter;

    Iter() throws IOException {
      parser = CSVInputData.this.newParser();
      innerIter = parser.iterator();
      skipHeaderIfExists(innerIter);
    }

    @Override
    public boolean hasNext() {
      final boolean hasNext = innerIter.hasNext();
      if (!hasNext) {
        try {
          parser.close();
        } catch (IOException e) {
          throw new IllegalStateException(e);
        }
      }
      return hasNext;
    }

    @Override
    public ArrayList<String> next() {
      return Lists.newArrayList(innerIter.next());
    }

    @Override
    public void close() throws IOException {
      parser.close();
    }

    @Override
    protected void finalize() throws Throwable {
      close();
    }

  }
}
