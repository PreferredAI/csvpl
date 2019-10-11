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

import ai.preferred.regression.EvaluateRegression;
import ai.preferred.regression.Shell;

public class E14_TrainTest {

  /**
   * DATA: data/icecream.txt
   * <p>
   * TODO:
   * Shuffle and partition the data in proportion 60/40, 60% is for the training data and 40% is for the testing data.
   * Train a regression on the training data and evaluate it on the testing data.
   * <p>
   * CHECK: Is RMSE (on testing) > RMSE[TRAINING] or RMSE (on testing) < RMSE[TRAINING]?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(EvaluateRegression.class);
  }

}
