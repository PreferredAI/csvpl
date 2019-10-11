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
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(RemoveColumn.class);
    Shell.help(SwapColumns.class);
  }

}
