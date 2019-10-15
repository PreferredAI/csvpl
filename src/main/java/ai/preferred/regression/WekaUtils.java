/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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
