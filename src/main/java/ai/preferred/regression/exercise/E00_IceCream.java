/*
 * Copyright 2019 Preferred.AI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
  public static void main(String[] args) {
    Shell.reset();

    Shell.run(PlotData.class, "-i data/icecream.csv -n IceCream");
  }

}
