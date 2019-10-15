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
import ai.preferred.regression.pe.SelectEquals;

public class E12_CameraWithAutoFocus {

  /**
   * DATA: data/camera.csv
   * <p>
   * TODO:
   * We are interested in the subset of 'camera.csv', the cameras with auto focus.
   * Select this subset and train a linear regression to predict price based on camera type.
   * <p>
   * CHECK: How many rows does the dataset have after processing?
   */
  public static void main(final String[] args) {
    Shell.reset();

    Shell.help(SelectEquals.class);
  }

}
