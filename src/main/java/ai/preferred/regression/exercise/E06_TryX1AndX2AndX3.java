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
import ai.preferred.regression.pe.AddX3;

public class E06_TryX1AndX2AndX3 {

  /**
   * DATA: data/icecream.csv
   * <p>
   * TODO:
   * Add columns Temperature^2 and Temperature^3 and train linear regression using all the parameters!
   * <p>
   * CHECK: Check RMSE[TRAINING] again, is it any different?
   */
  public static void main(String[] args) {
    Shell.reset();
    // TODO: implement AddX3.class, hint: take a look at the AddX2 class
    Shell.help(AddX3.class);
  }

}
