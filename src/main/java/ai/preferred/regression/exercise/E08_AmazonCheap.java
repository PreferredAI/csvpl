package ai.preferred.regression.exercise;

import ai.preferred.regression.Shell;
import ai.preferred.regression.pe.ProjectColumns;

public class E08_AmazonCheap {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Train a linear regression for rating prediction based on word "cheap" only! Plot it!
   * <p>
   * CHECK: What are the regression parameters? Is word "cheap" a good predictor?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(ProjectColumns.class);
  }

}
