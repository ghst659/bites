package tc.bites;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  Given a collection of distinct numbers, return all possible permutations.
 *  For example,
 *  [1,2,3] have the following permutations:
 *  [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 *  ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            // pass
        } else if (nums.length == 1) {
            List<Integer> item = new LinkedList<>();
            item.add(nums[0]);
            result.add(item);
        } else {
            int len = nums.length;
            for (int head = 0; head < len; ++head) {
                int tail = (head + len - 1) % len;
                int[] rest = new int[len - 1];
                for (int i = 0; i < rest.length; ++i) {
                    int j = (head + i + 1) % len;
                    rest[i] = nums[j];
                }
                List<List<Integer>> others = permute(rest);
                for (List<Integer> other : others) {
                    List<Integer> item = new LinkedList<>();
                    item.add(nums[head]);
                    item.addAll(other);
                    result.add(item);
                }
            }
        }
        return result;
    }
}
