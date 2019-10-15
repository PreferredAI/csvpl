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
import ai.preferred.regression.pe.Partition;
import ai.preferred.regression.pe.Shuffle;

public class E13_ShuffleAndPartitionIceCream {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * We are back to 'icecream.csv'.
   * Shuffle and partition the data in proportion 80/20, 80% is for training data and 20% is for testing data.
   * Plot the data splits.
   * <p>
   * CHECK: How many rows are there in the training and testing datasets?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.help(Shuffle.class);
    Shell.help(Partition.class);
  }

}
