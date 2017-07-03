package tc.bites;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to
 * the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        boolean stillIso = true;
        Map<Character,Character> s2t = new HashMap<>();
        Set<Character> tchars = new HashSet<>();
        for (int i = 0; stillIso && i < s.length(); ++i) {
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            if (s2t.containsKey(cs)) {
                Character rt = s2t.get(cs);
                if (rt != ct) {
                    stillIso = false;
                }
            } else if (tchars.contains(ct)) {
                stillIso = false;
            } else {
                s2t.put(cs, ct);
                tchars.add(ct);
            }
        }
        return stillIso;
    }
}
