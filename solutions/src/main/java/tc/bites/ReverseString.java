package tc.bites;

/**
 * Created by tsc on 9/26/16.
 */
public class ReverseString {
    public String reverseString(String s) {
        StringBuffer buf = new StringBuffer();
        for (int i = s.length()-1; i >= 0; --i) {
            char c = s.charAt(i);
            buf.append(c);
        }
        String result = buf.toString();
        return result;
    }
}
