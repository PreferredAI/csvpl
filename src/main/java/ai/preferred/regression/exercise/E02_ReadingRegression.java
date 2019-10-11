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

import ai.preferred.regression.PrintRegression;
import ai.preferred.regression.Shell;
import ai.preferred.regression.TrainLinearRegression;

public class E02_ReadingRegression {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * You can print the regression weights, to understand it a bit better!
   * <p>
   * CHECK: What is the value of the regression when Temperature is 0?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.run(TrainLinearRegression.class, "-i data/icecream.csv -m temp/icecream.model");
    Shell.run(PrintRegression.class, "-i data/icecream.csv -m temp/icecream.model");
  }

}
