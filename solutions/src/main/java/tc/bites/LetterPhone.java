package tc.bites;

import java.util.*;

/*
 * Given a digit string, return all possible letter combinations that the number could
 * represent.A mapping of digit to letters is
 * 1:
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
 * 0: space
 * *: +
 * #:
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterPhone {
    public static Map<Character, Character[]> DLMAP = new HashMap<>();
    static {
        DLMAP.put('1', new Character[]{});
        DLMAP.put('2', new Character[]{'a', 'b', 'c'});
        DLMAP.put('3', new Character[]{'d', 'e', 'f'});
        DLMAP.put('4', new Character[]{'g', 'h', 'i'});
        DLMAP.put('5', new Character[]{'j', 'k', 'l'});
        DLMAP.put('6', new Character[]{'m', 'n', 'o'});
        DLMAP.put('7', new Character[]{'p', 'q', 'r', 's'});
        DLMAP.put('8', new Character[]{'t', 'u', 'v'});
        DLMAP.put('9', new Character[]{'w', 'x', 'y', 'z'});
        DLMAP.put('0', new Character[]{' '});
        DLMAP.put('*', new Character[]{'*', '+'});
        DLMAP.put('#', new Character[]{});
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        genHelper(result, "", digits);
        return result;
    }
    private void genHelper(List<String> result, String accumulated, String digits) {
        if (digits.isEmpty()) {
            if (! accumulated.isEmpty())
                result.add(accumulated);
        } else {
            Character digit = digits.charAt(0);
            for (Character letter: DLMAP.get(digit)) {
                String newAccum = accumulated + letter;
                genHelper(result, newAccum, digits.substring(1));
            }
        }
    }
}

