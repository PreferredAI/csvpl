package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.Partition;
import ai.preferred.regression.pe.Shuffle;

public class E13_ShuffleAndPartitionIceCream {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * We are back to 'icecream.csv'.
   * Shuffle and partition the data in proportion 80/20, 80% is for training data and 20% is for testing data.
   * Plot the data splits.
   * <p>
   * CHECK: How many rows are there in the training and testing datasets?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(Shuffle.class);
    Shell.help(Partition.class);
  }

}
