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
import ai.preferred.regression.pe.AddX2;

public class E05_TryX2Only {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Add column Temperature^2 and train linear regression to predict consumption based only on Temperature^2 feature.
   * Plot the trained regression!
   * <p>
   * CHECK: Is RMSE[TRAINING] different from 'E01_MyFirstRegressionWithIceCream'?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(AddX2.class);
  }

}
