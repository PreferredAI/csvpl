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

package ai.preferred.regression.pe.data;

import java.util.*;

public class Vocabulary {

  private final ArrayList<String> vocabularyList;
  private final Map<String, Integer> vocabularyMap;

  public Vocabulary(Collection<String> vocabulary) {
    vocabularyList = new ArrayList<>(vocabulary);
    Collections.sort(vocabularyList);
    vocabularyMap = new HashMap<>(vocabularyList.size());
    for (final String w : vocabularyList) {
      vocabularyMap.put(w, vocabularyMap.size());
    }
  }

  public List<String> getVocabularyList() {
    return Collections.unmodifiableList(vocabularyList);
  }

  public String[] getVocabularyArray() {
    return vocabularyList.toArray(new String[0]);
  }

  public int getIndex(String w) {
    final Integer index = vocabularyMap.get(w);
    if (index == null) {
      return 0;
    }
    return index;
  }

  public String getWord(int index) {
    if (index >= 0 && index < vocabularyList.size()) {
      return vocabularyList.get(index);
    }
    throw new IllegalArgumentException("No such index in the vocabulary: " + index);
  }

  public int size() {
    return vocabularyList.size();
  }

  @Override
  public String toString() {
    return "Vocabulary{" + vocabularyList + '}';
  }
}
