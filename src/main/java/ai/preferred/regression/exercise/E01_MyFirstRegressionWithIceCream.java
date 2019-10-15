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

package ai.preferred.regression.exercise;

import ai.preferred.regression.PlotLinearRegression;
import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLinearRegression;

public class E01_MyFirstRegressionWithIceCream {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Train a linear regression on 'icecream.csv'. Plot the regression line.
   * <p>
   * CHECK: What is the value of RMSE[TRAINING] for this dataset?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.run(TrainLinearRegression.class, "-i data/icecream.csv -m temp/icecream.model");
    Shell.run(PlotLinearRegression.class, "-i data/icecream.csv -m temp/icecream.model");
  }

}
