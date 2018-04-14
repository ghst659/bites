package tc.bites;

public class TextDelta {
    public int index;
    public String original;
    public String altered;
    public TextDelta(int i, String o, String a) {
        index = i;
        original = o;
        altered = a;
    }
}
