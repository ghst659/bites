package tc.bites;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tsc on 1/17/17.
 */
public class ValidParentheses {
    private static Map<Character,Character> CONJUGATE = new HashMap<>();
    static {
        final Character C_OPENS[] = { '(', '{', '[', '<' };
        final Character C_CLOSE[] = { ')', '}', ']', '>' };
        for (int i = 0; i < C_OPENS.length; ++i) {
            Character c_ouvrir = C_OPENS[i];
            Character c_fermer = C_CLOSE[i];
            CONJUGATE.put(c_ouvrir, c_fermer);
        }
    }
    public boolean isValid(String s) {
        boolean result = false;
        if (s != null) {
            result = true;
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; result && i < s.length(); ++i) {
                Character c = s.charAt(i);
                if (CONJUGATE.containsKey(c)) {
                    stack.push(c);
                } else if (stack.size() < 1) {
                    result = false;
                } else {
                    Character p = stack.pop();
                    Character e = CONJUGATE.get(p);
                    result = (e == c);
                }
            }
            if (stack.size()  != 0) {
                result = false;
            }
        }
        return result;
    }
}
