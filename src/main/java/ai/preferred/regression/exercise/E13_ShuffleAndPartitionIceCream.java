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
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(Shuffle.class);
    Shell.help(Partition.class);
  }

}
