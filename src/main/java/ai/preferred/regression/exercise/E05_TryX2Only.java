package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.AddX2;

public class E05_TryX2Only {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Add column Temperature^2 and train linear regression to predict consumption based only on Temperature^2 feature.
   * Plot the trained regression!
   * <p>
   * CHECK: Is RMSE[TRAINING] different from 'E01_MyFirstRegressionWithIceCream'?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(AddX2.class);
  }

}
