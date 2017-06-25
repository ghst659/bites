package tc.bites;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without
 * repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence
 * and not a substring.
 */
public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        return lv1(s);
    }
    private static Map<Character, Integer> pos = new HashMap<>();
    public int lv0(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        pos.clear();
        int maxIdx = s.length() - 1;
        int maxLen = 1;
        int first = 0;
        int last = 0;
        pos.put(s.charAt(first), first);
        while (last < maxIdx) {
            int next = last + 1;
            Character nextChar = s.charAt(next);
            if (pos.containsKey(nextChar)) {
                // we have a repeat
                // restart the sequence after the repeat
                int newFirst = pos.get(nextChar) + 1;
                for (int i = first; i < newFirst; ++i) {
                    pos.remove(s.charAt(i));
                }
                first = newFirst;
            }
            pos.put(nextChar, next);
            last = next;
            int curLen = last - first + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
    private final static int SIZE = 512;
    private static int[] seqPos = new int[SIZE];
    public int lv1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Arrays.fill(seqPos, -1);
        int maxIdx = s.length() - 1;
        int maxLen = 1;
        int first = 0;
        int last = 0;
        seqPos[s.charAt(first)] = first;
        while (last < maxIdx) {
            int next = last + 1;
            Character nextChar = s.charAt(next);
            if (seqPos[nextChar] >= 0) {
                // we have a repeat
                // restart the sequence after the repeat
                int newFirst = seqPos[nextChar] + 1;
                for (int i = first; i < newFirst; ++i) {
                    seqPos[s.charAt(i)] = -1;
                }
                first = newFirst;
            }
            seqPos[nextChar] = next;
            last = next;
            int curLen = last - first + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
}
