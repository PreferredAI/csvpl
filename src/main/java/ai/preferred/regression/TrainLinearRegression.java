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
import org.kohsuke.args4j.Option;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.File;
import java.io.FileOutputStream;

public class TrainLinearRegression extends Command {

  @Option(name = "-i", aliases = {"--train"}, usage = "the path to the training data in CSV format", required = true)
  private File input;

  @Option(name = "-m", aliases = {"--model"}, usage = "the output path to the model file", required = true)
  private File model;

  @Option(name = "-h", aliases = {"--header"}, usage = "specifies if the input CSV files have headers")
  private boolean header = true;

  @Option(name = "-r", aliases = {"--ridge"}, usage = "the ridge parameter")
  private double ridge = 1.0;

  @Option(name = "-v", aliases = {"--verbose"}, usage = "verbosity level (-1 - disable, 0 - short, 1 - default)")
  private int verbose = 1;

  @Override
  protected void exec() throws Exception {
    final ARFFDataReader reader = new ARFFDataReader(input, false, header);
    final Instances data = reader.read(input);
    final weka.classifiers.functions.LinearRegression classifier = new weka.classifiers.functions.LinearRegression();
    classifier.setRidge(ridge);
    classifier.buildClassifier(data);

    final Evaluation eval = new Evaluation(data);
    eval.evaluateModel(classifier, data);
    if (verbose <= -1) {
      // output disabled
    } else if (verbose == 0) {
      System.out.println(eval.rootMeanSquaredError());
    } else {
      System.out.println("RMSE[TRAINING] = " + eval.rootMeanSquaredError());
    }

    SerializationHelper.write(new FileOutputStream(model), classifier);
  }

  public static void main(String[] args) {
    parseArgsAndRun(TrainLinearRegression.class, args);
  }

}
