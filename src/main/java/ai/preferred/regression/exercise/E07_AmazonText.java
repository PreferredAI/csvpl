package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.EncodeTextAsFrequency;

public class E07_AmazonText {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Take a loot at 'amazon.csv', one of the columns contains text.
   * Convert it into word frequencies using EncodeTextAsFrequency.class.
   * <p>
   * CHECK: How many columns does the new dataset have after conversion?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(EncodeTextAsFrequency.class);
  }

}
