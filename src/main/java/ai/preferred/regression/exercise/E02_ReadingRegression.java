package ai.preferred.regression.exercise;

import ai.preferred.regression.PrintRegression;
import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLinearRegression;

public class E02_ReadingRegression {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * You can print the regression weights, to understand it a bit better!
   * <p>
   * CHECK: What is the value of the regression when Temperature is 0?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.run(TrainLinearRegression.class, "-i data/icecream.csv -m temp/icecream.model");
    Shell.run(PrintRegression.class, "-i data/icecream.csv -m temp/icecream.model");
  }

}
