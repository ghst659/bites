package tc.bites;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tsc on 3/11/17.
 */
public class MakeChange {
    public static Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

    public static void reset() {
        memo.clear();
    }

    protected int count(Map<Integer, Integer> change) {
        int result = 0;
        for (Map.Entry<Integer, Integer> kv : change.entrySet()) {
            result += kv.getValue();
        }
        return result;
    }

    protected void copy(Map<Integer, Integer> src, Map<Integer, Integer> dst) {
        dst.clear();
        for (Map.Entry<Integer, Integer> kv : src.entrySet()) {
            dst.put(kv.getKey(), kv.getValue());
        }
    }

    public Map<Integer, Integer> change(int amount, Set<Integer> denominations) {
        Map<Integer, Integer> result = new HashMap<>();
        if (amount > 0) {
            if (memo.containsKey(amount)) {
                copy(memo.get(amount), result);
            } else {
                for (int coin : denominations) {
                    if (amount < coin) {
                        continue;
                    } else if (amount == coin) {
                        result.clear();
                        result.put(coin, 1);
                        break;
                    } else {
                        int remainder = amount - coin;
                        Map<Integer, Integer> previous = change(remainder, denominations);
                        if (result.size() == 0 || count(result) > count(previous) + 1) {
                            copy(previous, result);
                            int prevCount = previous.containsKey(coin) ? previous.get(coin) : 0;
                            result.put(coin, prevCount + 1);
                        } else {
                            // this result is not better, do nothing
                        }
                    }
                    memo.put(amount, result);
                }
            }
        }
        return result;
    }
}