package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLogisticRegression;

public class E17_AmazonLogistic {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Build and evaluate a logistic regression model. Data split: 80/20.
   * <p>
   * CHECK: Is ACCURACY (on testing) > ACCURACY[TRAINING] or ACCURACY (on testing) < ACCURACY[TRAINING]?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(TrainLogisticRegression.class);
  }

}
