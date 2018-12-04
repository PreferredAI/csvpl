package ai.preferred.regression.exercise;

import ai.preferred.regression.EvaluateRegression;
import ai.preferred.regression.Shell;

public class E14_TrainTest {

  /**
   * DATA: data/icecream.txt
   * <p>
   * TODO:
   * Shuffle and partition the data in proportion 60/40, 60% is for the training data and 40% is for the testing data.
   * Train a regression on the training data and evaluate it on the testing data.
   * <p>
   * CHECK: Is RMSE (on testing) > RMSE[TRAINING] or RMSE (on testing) < RMSE[TRAINING]?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(EvaluateRegression.class);
  }

}
