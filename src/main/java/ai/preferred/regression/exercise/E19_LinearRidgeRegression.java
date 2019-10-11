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
import ai.preferred.regression.TrainLinearRegression;

public class E19_LinearRidgeRegression {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Build and evaluate a linear regression model with ridge = {0.1, 1.0, 10.0}. Data split: 80/20.
   * <p>
   * CHECK: Which ridge parameter gives the best RMSE (on testing)?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(TrainLinearRegression.class);
  }

}
