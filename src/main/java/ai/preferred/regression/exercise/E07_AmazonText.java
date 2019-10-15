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
import ai.preferred.regression.pe.EncodeTextAsFrequency;

public class E07_AmazonText {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Take a loot at 'amazon.csv', one of the columns contains text.
   * Convert it into word frequencies using EncodeTextAsFrequency.class.
   * <p>
   * CHECK: How many columns does the new dataset have after conversion?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.help(EncodeTextAsFrequency.class);
  }

}
