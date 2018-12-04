package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLinearRegression;

public class E19_LinearRidgeRegression {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Build and evaluate a linear regression model with ridge = {0.1, 1.0, 10.0}. Data split: 80/20.
   * <p>
   * CHECK: Which ridge parameter gives the best RMSE (on testing)?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(TrainLinearRegression.class);
  }

}
