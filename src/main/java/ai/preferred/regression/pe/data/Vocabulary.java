/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
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
