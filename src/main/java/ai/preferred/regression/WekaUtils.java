package ai.preferred.regression;

import weka.classifiers.Classifier;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;

public class WekaUtils {

  static boolean isLogisticClassifier(Classifier classifier) {
    boolean nominal;
    if (classifier instanceof Logistic) {
      nominal = true;
    } else if (classifier instanceof LinearRegression) {
      nominal = false;
    } else {
      throw new IllegalStateException("The model is neither LogisticRegression nor LinearRegression!");
    }
    return nominal;
  }

  private WekaUtils() {
    throw new AssertionError();
  }

}
