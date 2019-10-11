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
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.File;
import java.io.FileInputStream;

public class EvaluateRegression extends Command {

  @Option(name = "-s", aliases = {"--train"}, usage = "the path to the training data", required = true)
  private File train;

  @Option(name = "-i", aliases = {"--test"}, usage = "the path to the testing data", required = true)
  private File test;

  @Option(name = "-m", aliases = {"--model"}, usage = "the path to the model file", required = true)
  private File model;

  @Option(name = "-v", aliases = {"--verbose"}, usage = "verbosity level (0 - short, 1 - default, 2 - detailed)")
  private int verbose = 1;

  @Option(name = "-h", aliases = {"--header"}, usage = "specifies if the input CSV files have headers")
  private boolean header = true;

  @Override
  protected void exec() throws Exception {
    try (final FileInputStream stream = new FileInputStream(model)) {
      final Classifier classifier = (Classifier) SerializationHelper.read(stream);
      final boolean nominal = WekaUtils.isLogisticClassifier(classifier);

      final ARFFDataReader reader = new ARFFDataReader(train, nominal, header);
      final Instances data = reader.read(test);

      final Evaluation eval = new Evaluation(data);
      eval.evaluateModel(classifier, data);
      if (nominal) {
        if (verbose <= 0) {
          System.out.println(eval.pctCorrect());
        } else if (verbose == 1) {
          System.out.println("ACCURACY = " + eval.pctCorrect());
        } else {
          System.out.println();
          System.out.println("CLASS\tPRECISION\tRECALL\tF-MEASURE");
          for (int i = 0; i < data.classAttribute().numValues(); i++) {
            System.out.printf("%s\t%f\t%f\t%f", data.classAttribute().value(i), eval.precision(i), eval.recall(i), eval.fMeasure(i));
            System.out.println();
          }
        }
      } else {
        if (verbose <= 0) {
          System.out.println(eval.rootMeanSquaredError());
        } else {
          System.out.println("RMSE = " + eval.rootMeanSquaredError());
        }
      }
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(EvaluateRegression.class, args);
  }

}
