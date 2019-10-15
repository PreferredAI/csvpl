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

import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLinearRegression;

public class E19_LinearRidgeRegression {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Build and evaluate a linear regression model with ridge = {0.1, 1.0, 10.0}. Data split: 80/20.
   * <p>
   * CHECK: Which ridge parameter gives the best RMSE (on testing)?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.help(TrainLinearRegression.class);
  }

}
