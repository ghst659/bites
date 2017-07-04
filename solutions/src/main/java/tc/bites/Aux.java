package tc.bites;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Auxiliary static routines
 */
public class Aux {
    public static String axStr(int[] ai) {
        return Arrays.toString(ai);
    }
    public static String axStr(boolean[] ab) {
        return Arrays.toString(ab);
    }
    public static String axStr(long[] al) {
        return Arrays.toString(al);
    }
    public static <T> String axStr(T[] a) {
        return axStr(a, (x)->x.toString());
    }
    public static <T> String axStr(T[] a, Function<T,String> toStr) {
        StringBuffer buf = new StringBuffer("[");
        if (a != null && a.length > 0) {
            for (int i = 0; i < a.length; ++i) {
                if (i > 0) {
                    buf.append(", ");
                }
                buf.append(toStr.apply(a[i]));
            }
        }
        buf.append("]");
        return buf.toString();
    }
}
