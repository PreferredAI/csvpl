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
import ai.preferred.regression.pe.RemoveColumn;
import ai.preferred.regression.pe.SwapColumns;

public class E03_RawIceCream {

  /**
   * DATA: data/icecream_raw.csv ; data/icecream.csv
   * <p>
   * TODO:
   * Often, data come in a format which is not suitable for analysis or for building a regression.
   * Convert 'icecream_raw.csv' to make it look like 'icecream.csv'.
   * <p>
   * CHECK: Should you use RemoveColumn or SwapColumns as the first step?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.help(RemoveColumn.class);
    Shell.help(SwapColumns.class);
  }

}
