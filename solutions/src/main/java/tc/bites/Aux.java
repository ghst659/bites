package tc.bites;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Auxiliary static routines
 */
public class Aux {
    public static String aiStr(int[] ai) {
        Integer[] aI = Arrays.stream(ai).boxed().toArray(Integer[]::new);
        String r = axStr(aI, (n)->Integer.toString(n));
        return r;
    }
    public static <T> String axStr(T[] a, Function<T,String> toStr) {
        StringBuffer buf = new StringBuffer("[");
        if (a != null && a.length > 0) {
            for (int i = 0; i < a.length; ++i) {
                if (i > 0) {
                    buf.append(",");
                }
                buf.append(toStr.apply(a[i]));
            }
        }
        buf.append("]");
        return buf.toString();
    }
}
