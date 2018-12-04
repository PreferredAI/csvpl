package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.RemoveColumn;
import ai.preferred.regression.pe.SwapColumns;

public class E03_RawIceCream {

  /**
   * DATA: data/icecream_raw.csv ; data/icecream.csv
   * <p>
   * TODO:
   * Often, data come in a format which is not suitable for analysis or for building a regression.
   * Convert 'icecream_raw.csv' to make it look like 'icecream.csv'.
   * <p>
   * CHECK: Should you use RemoveColumn or SwapColumns as the first step?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(RemoveColumn.class);
    Shell.help(SwapColumns.class);
  }

}
