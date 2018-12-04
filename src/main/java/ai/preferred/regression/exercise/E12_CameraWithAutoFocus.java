package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.SelectEquals;

public class E12_CameraWithAutoFocus {

  /**
   * DATA: data/camera.csv
   * <p>
   * TODO:
   * We are interested in the subset of 'camera.csv', the cameras with auto focus.
   * Select this subset and train a linear regression to predict price based on camera type.
   * <p>
   * CHECK: How many rows does the dataset have after processing?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(SelectEquals.class);
  }

}
