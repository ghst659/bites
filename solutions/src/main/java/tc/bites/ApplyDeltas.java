package tc.bites;

import java.util.List;

public class ApplyDeltas {
    public static String apply(String source, List<TextDelta> changes) {
        if (source == null) {
            return null;
        }
        if (changes == null || changes.size() == 0) {
            return source;
        }
        StringBuilder buf = new StringBuilder();
        int last = 0;
        for (TextDelta delta: changes) {
            buf.append(source.substring(last, delta.index));
            buf.append(delta.altered);
            last = delta.index + delta.original.length();
        }
        if (last < source.length()) {
            buf.append(source.substring(last));
        }
        return buf.toString();
    }
}
