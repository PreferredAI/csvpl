package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.EncodeValueAsOneHot;

/**
 * DATA: data/camera.csv
 * <p>
 * TODO:
 * Take a look at 'camera.csv'. It has a lot of categorical data, which is to be
 * processed and represented as 0-1 values.
 * <p>
 * CHECK: How many columns does the dataset have after processing?
 */
public class E11_CameraCategories {

  public static void main(String[] args) {
    Shell.reset();

    Shell.help(EncodeValueAsOneHot.class);
  }

}
