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
import ai.preferred.regression.pe.EncodeValueAsOneHot;

/**
 * DATA: data/camera.csv
 * <p>
 * TODO:
 * Take a look at 'camera.csv'. It has a lot of categorical data, which is to be
 * processed and represented as 0-1 values.
 * <p>
 * CHECK: How many columns does the dataset have after processing?
 */
public class E11_CameraCategories {

  public static void main(String[] args) {
    Shell.reset();

    Shell.help(EncodeValueAsOneHot.class);
  }

}
