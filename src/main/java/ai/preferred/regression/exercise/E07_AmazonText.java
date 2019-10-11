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
import ai.preferred.regression.pe.EncodeTextAsFrequency;

public class E07_AmazonText {

  /**
   * DATA: data/amazon.csv
   * <p>
   * TODO:
   * Take a loot at 'amazon.csv', one of the columns contains text.
   * Convert it into word frequencies using EncodeTextAsFrequency.class.
   * <p>
   * CHECK: How many columns does the new dataset have after conversion?
   */
  public static void main(String[] args) {
    Shell.reset();

    Shell.help(EncodeTextAsFrequency.class);
  }

}
