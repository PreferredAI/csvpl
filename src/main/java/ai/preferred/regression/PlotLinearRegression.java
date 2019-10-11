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

package ai.preferred.regression;

import ai.preferred.regression.io.ARFFDataReader;
import ai.preferred.regression.plot.XYChart;
import org.jfree.data.xy.XYSeries;
import org.kohsuke.args4j.Option;
import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PlotLinearRegression extends Command {

  @Option(name = "-i", aliases = {"--input"}, usage = "the path to the input CSV file", required = true)
  private File input;

  @Option(name = "-m", aliases = {"--model"}, usage = "the path to the model file", required = true)
  private File model;

  @Option(name = "-n", aliases = {"--name"}, usage = "the name of the plot")
  private String name = "Y = alpha * X + beta";

  @Option(name = "-h", aliases = {"--header"}, usage = "specifies if the input CSV files have headers")
  private boolean header = true;

  @Override
  protected void exec() throws Exception {
    try (final FileInputStream stream = new FileInputStream(model)) {
      final Classifier classifier = (Classifier) SerializationHelper.read(stream);
      if (!(classifier instanceof LinearRegression)) {
        throw new IOException("The model is neither LogisticRegression nor LinearRegression!");
      }
      final double[] w = ((LinearRegression) classifier).coefficients();

      if (w.length != 3) {
        throw new IOException("We can plot only linear functions!");
      }

      final ARFFDataReader reader = new ARFFDataReader(input, false, header);
      final Instances data = reader.read(input);

      final XYSeries dataSeries = new XYSeries("DATA");
      for (final Instance datum : data) {
        dataSeries.add(datum.value(1), datum.value(0));
      }
      final XYSeries regressionSeries = new XYSeries("REGRESSION");
      regressionSeries.add(dataSeries.getMinX(), w[1] * dataSeries.getMinX() + w[2]);
      regressionSeries.add(dataSeries.getMaxX(), w[1] * dataSeries.getMaxX() + w[2]);

      final XYChart chart = new XYChart(name, dataSeries, regressionSeries);
      chart.pack();
      chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      chart.setVisible(true);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(PlotLinearRegression.class, args);
  }

}
