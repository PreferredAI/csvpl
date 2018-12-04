package ai.preferred.regression.exercise;

import ai.preferred.regression.PlotLinearRegression;
import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLinearRegression;

public class E01_MyFirstRegressionWithIceCream {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Train a linear regression on 'icecream.csv'. Plot the regression line.
   * <p>
   * CHECK: What is the value of RMSE[TRAINING] for this dataset?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.run(TrainLinearRegression.class, "-i data/icecream.csv -m temp/icecream.model");
    Shell.run(PlotLinearRegression.class, "-i data/icecream.csv -m temp/icecream.model");
  }

}
