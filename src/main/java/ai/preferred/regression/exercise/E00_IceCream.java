package ai.preferred.regression.exercise;

import ai.preferred.regression.PlotData;
import ai.preferred.regression.Shell;

public class E00_IceCream {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Run this class to plot the input data, take a look at it!
   * You can open the data file in Excel or Google Spreadsheet.
   * <p>
   * CHECK: Is it possible to approximate this data with a linear function?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.run(PlotData.class, "-i data/icecream.csv -n IceCream");
  }

}
