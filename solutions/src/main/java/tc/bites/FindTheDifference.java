package tc.bites;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  Given two strings s and t which consist of only lowercase letters.
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * Find the letter that was added in t.
 * Example:
 * Input:
 * s = "abcd"
 * t = "abcde"
 * Output:
 * e
 * Explanation:
 * 'e' is the letter that was added.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        return findTheDifferenceFast(s, t);
    }
    private static final int SIZE = 26;
    private static int[] count = new int[SIZE];
    public char findTheDifferenceFast(String s, String t) {
        Arrays.fill(count, 0);
        int sL = s.length();
        for (int i = 0; i < sL; ++i) {
            int c = s.charAt(i) - 'a';
            ++count[c];
        }
        int tL = t.length();
        for (int i = 0; i < tL; ++i) {
            char ct = t.charAt(i);
            int c = ct - 'a';
            if (count[c] < 1) {
                return ct;
            } else {
                --count[c];
            }
        }
        return 0;
    }
    public char findTheDifferenceGeneral(String s, String t) {
        char result = 0;
        Map<Character, Integer> sCnt = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char cs = s.charAt(i);
            if (sCnt.containsKey(cs)) {
                sCnt.put(cs, sCnt.get(cs) + 1);
            } else {
                sCnt.put(cs, 1);
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            char ct = t.charAt(i);
            if (sCnt.containsKey(ct)) {
                int newCount = sCnt.get(ct) - 1;
                if (newCount >= 0) {
                    sCnt.put(ct, newCount);
                } else {
                    result = ct;
                    break;
                }
            } else {
                result = ct;
                break;
            }
        }
        return result;
    }
}