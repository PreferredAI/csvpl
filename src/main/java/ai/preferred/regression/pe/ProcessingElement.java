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
import ai.preferred.regression.io.CSVUtils;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public abstract class ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessingElement.class);

  @Option(name = "-i", aliases = {"--input"}, usage = "the path to the input CSV file", required = true)
  private File input;

  @Option(name = "-o", aliases = {"--output"}, usage = "the path to the output CSV file", required = true)
  private File output;

  @Option(name = "-h", aliases = {"--header"}, usage = "specifies if the input CSV files have headers")
  private boolean header = true;

  public ProcessingElement() {
  }

  protected abstract void process(CSVInputData data, CSVPrinter printer) throws Exception;

  protected static void parseArgsAndRun(Class<? extends ProcessingElement> clazz, String[] args) {
    ProcessingElement processingElement = null;
    try {
      processingElement = clazz.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      System.err.println("Please check if there is the public default constructor for the class: " + clazz.getCanonicalName());
      System.exit(1);
    }

    if (args == null) {
      System.out.println("=========== HELP ===========");
      System.out.println();
      System.out.println("Processing Element: " + clazz.getSimpleName() + ".class");
      System.out.println();
      System.out.println("Shell.run(" + clazz.getSimpleName() + ".class, \"\");");
      final CmdLineParser parser = new CmdLineParser(processingElement);
      System.out.println();
      parser.printUsage(System.out);
      System.out.println();
      System.out.println("============================");
      System.out.println();
      System.out.println();
      return;
    }

    final CmdLineParser parser = new CmdLineParser(processingElement);
    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      System.err.println("ProcessingElement: " + clazz.getCanonicalName());
      System.err.println(e.getMessage());
      System.err.println();
      parser.printUsage(System.err);
      System.exit(1);
    }

    if (processingElement.input.equals(processingElement.output)) {
      LOGGER.error("The input and output files point to the same location: {}", processingElement.input);
      System.exit(1);
    }

    try (final CSVPrinter printer = CSVUtils.printer(processingElement.output);
         final CSVInputData reader = CSVUtils.reader(processingElement.input, processingElement.header)) {
      try {
        processingElement.process(reader, printer);
      } catch (Exception e) {
        LOGGER.error("Unexpected error: ", e);
        System.exit(1);
      }
    } catch (IOException e) {
      LOGGER.error("Unable to process files: ", e);
      System.exit(1);
    }
  }

}
