package tc.bites;

import java.util.*;

/**
 * Given an input string and a dictionary of words,
 * return all the combinations of words from the dictionary
 * that can be concatenated into the input string.
 */
public class WordBreak {
    private int callCount = 0;
    private Map<String, List<List<String>>> memo = new HashMap<>();
    public int calls() {
        return callCount;
    }
    public void reset() {
        callCount = 0;
        for (Map.Entry<String,List<List<String>>> m: this.memo.entrySet()) {
            for (List<String> l: m.getValue()) {
                l.clear();
            }
            m.getValue().clear();
        }
        this.memo.clear();
    }
    private Set<String> dict = new HashSet<>();
    public boolean caseFold = true;
    public void learn(String word) {
        this.dict.add(caseFold ? word.toLowerCase(): word);
    }
    public void learn(String... words) {
        for (String word: words) {
            this.dict.add(caseFold ? word.toLowerCase() : word);
        }
    }
    public void learn(Collection<String> words) {
        for (String word: words) {
            this.dict.add(caseFold ? word.toLowerCase() : word);
        }
    }
    public Set<String> recite() {
        Set<String> result = new HashSet<>();
        result.addAll(this.dict);
        return result;
    }
    public boolean know(String word) {
        return this.dict.contains(word);
    }
    public int size() {
        return this.dict.size();
    }
    public List<List<String>> wordBreaks(String inputString, int depth) {
        List<List<String>> result = new LinkedList<>();
        if (this.memo.containsKey(inputString)) {
            return this.memo.get(inputString);
        } else {
            this.callCount++;
            int len = inputString.length();
            if (len == 0) {
                result.add(new LinkedList<>());
            } else {
                for (int i = 1; i <= len; ++i) {
                    String prefix = inputString.substring(0, i);
                    String remainder = inputString.substring(i, len);
                    if (know(prefix)) {
                        List<List<String>> possibleRemainders = this.wordBreaks(remainder, depth + 1);
                        for (List<String> option : possibleRemainders) {
                            List<String> resultItem = new LinkedList<>();
                            resultItem.add(prefix);
                            resultItem.addAll(option);
                            result.add(resultItem);
                        }
                    }
                }
            }
            this.memo.put(inputString, result);
        }
        return result;
    }
 }
