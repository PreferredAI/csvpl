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

import ai.preferred.regression.EvaluateRegression;
import ai.preferred.regression.Shell;

public class E14_TrainTest {

  /**
   * DATA: data/icecream.txt
   * <p>
   * TODO:
   * Shuffle and partition the data in proportion 60/40, 60% is for the training data and 40% is for the testing data.
   * Train a regression on the training data and evaluate it on the testing data.
   * <p>
   * CHECK: Is RMSE (on testing) > RMSE[TRAINING] or RMSE (on testing) < RMSE[TRAINING]?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.help(EvaluateRegression.class);
  }

}
