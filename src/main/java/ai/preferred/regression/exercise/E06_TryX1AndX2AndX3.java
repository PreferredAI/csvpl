package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.AddX3;

public class E06_TryX1AndX2AndX3 {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Add columns Temperature^2 and Temperature^3 and train linear regression using all the parameters!
   * <p>
   * CHECK: Check RMSE[TRAINING] again, is it any different?
   */
  public static void main(String[] args) {
    Shell.reset();
    // TODO: implement AddX3.class, hint: take a look at the AddX2 class
    Shell.help(AddX3.class);
  }

}
