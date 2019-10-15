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

package ai.preferred.regression;

import ai.preferred.regression.io.ARFFDataReader;
import org.kohsuke.args4j.Option;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.File;
import java.io.FileOutputStream;

public class TrainLogisticRegression extends Command {

  @Option(name = "-i", aliases = {"--train"}, usage = "the path to the training data in CSV format", required = true)
  private File input;

  @Option(name = "-m", aliases = {"--model"}, usage = "the output path to the model file", required = true)
  private File model;

  @Option(name = "-h", aliases = {"--header"}, usage = "specifies if the input CSV files have headers")
  private boolean header = true;

  @Option(name = "-r", aliases = {"--ridge"}, usage = "the ridge parameter")
  private double ridge = 1.0;

  @Option(name = "-v", aliases = {"--verbose"}, usage = "verbosity level (-1 - disable, 0 - short, 1 - default, 2 - detailed)")
  private int verbose = 1;

  @Override
  protected void exec() throws Exception {
    final ARFFDataReader reader = new ARFFDataReader(input, true, header);
    final Instances data = reader.read(input);
    final weka.classifiers.functions.Logistic classifier = new weka.classifiers.functions.Logistic();
    classifier.setRidge(ridge);
    classifier.buildClassifier(data);

    final Evaluation eval = new Evaluation(data);
    eval.evaluateModel(classifier, data);
    if (verbose <= -1) {
      // output disabled
    } else if (verbose == 0) {
      System.out.println(eval.pctCorrect());
    } else if (verbose == 1) {
      System.out.println("ACCURACY[TRAINING] = " + eval.pctCorrect());
    } else {
      System.out.println();
      System.out.println("CLASS\tPRECISION\tRECALL\tF-MEASURE");
      for (int i = 0; i < data.classAttribute().numValues(); i++) {
        System.out.printf("%s\t%f\t%f\t%f", data.classAttribute().value(i), eval.precision(i), eval.recall(i), eval.fMeasure(i));
        System.out.println();
      }
    }

    SerializationHelper.write(new FileOutputStream(model), classifier);
  }

  public static void main(String[] args) {
    parseArgsAndRun(TrainLogisticRegression.class, args);
  }


}
