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
  public static void main(final String[] args) {
    Shell.reset();

    Shell.run(PlotData.class, "-i data/icecream.csv -n IceCream");
  }

}
