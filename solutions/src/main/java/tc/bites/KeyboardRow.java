package tc.bites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a List of words, return the words that can be typed using
 * letters of alphabet on only one row's of American keyboard.
 */
public class KeyboardRow {
    protected static String[] ROWS = {
        "qwertyuiop",
        "asdfghjkl",
        "zxcvbnm"
    };
    protected static Set<Character>[] ROWSET = new Set[ROWS.length];
    static {
        for (int i = 0; i < ROWS.length; ++i) {
            ROWSET[i] = new HashSet<>();
            for (int j = 0; j < ROWS[i].length(); ++j) {
                Character c = ROWS[i].charAt(j);
                ROWSET[i].add(c);
            }
        }
    }
    protected boolean inOneRow(String rawWord) {
        boolean result = true;
        String word = rawWord.toLowerCase();
        int rowIdx = -1;
        for (int j = 0; result && j < word.length(); ++j) {
            Character c = word.charAt(j);
            if (rowIdx < 0) {
                for (int i = 0; rowIdx < 0 && i < ROWSET.length; ++i) {
                    if (ROWSET[i].contains(c)) {
                        rowIdx = i;
                    }
                }
            } else {
                result = ROWSET[rowIdx].contains(c);
            }
        }
        return result;
    }
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (this.inOneRow(word)) {
                result.add(word);
            }
        }
        String[] retval = new String[result.size()];
        return result.toArray(retval);
    }
}
