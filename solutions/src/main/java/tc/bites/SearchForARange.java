package tc.bites;

import java.util.Arrays;

/**
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums != null && nums.length > 0) {
            int lo = loPos(nums, target);
            int hi = hiPos(nums, target);
            if (lo > hi) {
                Arrays.fill(result, -1);
            } else {
                result[0] = lo;
                result[1] = hi;
            }
        } else {
            Arrays.fill(result, -1);
        }
        return result;
    }
    public static int loPos(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            if (target > nums[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target ? lo : lo + 1;
    }
    public static int hiPos(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            if (target < nums[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return nums[hi] == target ? hi : hi - 1;
    }
}
