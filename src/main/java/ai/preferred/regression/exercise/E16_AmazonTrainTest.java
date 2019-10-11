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

public class E16_AmazonTrainTest {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Let's go to the amazon data: 'amazon.csv'.
   * Split the data in proportion 80/20.
   * Build a regression on the training split and evaluate it on the testing.
   * <p>
   * CHECK: Is RMSE (on testing) > RMSE[TRAINING] or RMSE (on testing) < RMSE[TRAINING]?
   */
  public static void main(String[] args) {
    Shell.reset();
  }

}
