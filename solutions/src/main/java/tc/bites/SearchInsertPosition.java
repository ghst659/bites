package tc.bites;

/**
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would
 * be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        if (nums != null && nums.length > 0) {
            int lo = 0;
            int hi = nums.length - 1;
            while (hi - lo > 1) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            if (target <= nums[lo]) {
                result = lo;
            } else if (target <= nums[hi]) {
                result = hi;
            } else {
                result = hi + 1;
            }
        }
        return result;
    }
}
