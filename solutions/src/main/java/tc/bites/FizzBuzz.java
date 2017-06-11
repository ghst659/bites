package tc.bites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsc on 3/11/17.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int k = 1; k <= n; ++k) {
            String word = encode(k);
            result.add(word);
        }
        return result;
    }
    protected String encode(int k) {
        String result;
        boolean m3 = (k % 3 == 0);
        boolean m5 = (k % 5 == 0);
        if (m3 & m5) {
            result = "FizzBuzz";
        } else if (m3) {
            result = "Fizz";
        } else if (m5) {
            result = "Buzz";
        } else {
            result = String.format("%d", k);
        }
        return result;
    }
}
