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
import ai.preferred.regression.pe.AddX3;

public class E06_TryX1AndX2AndX3 {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Add columns Temperature^2 and Temperature^3 and train linear regression using all the parameters!
   * <p>
   * CHECK: Check RMSE[TRAINING] again, is it any different?
   */
  public static void main(final String[] args) {
    Shell.reset();
    // TODO: implement AddX3.class, hint: take a look at the AddX2 class
    Shell.help(AddX3.class);
  }

}
