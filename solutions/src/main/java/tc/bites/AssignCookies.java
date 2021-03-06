package tc.bites;

import java.util.Arrays;

/**
 * Assume you are an awesome parent and want to give
 * your children some cookies. But, you should give each
 * child at most one cookie. Each child i has a greed factor gi,
 * which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj.
 * If sj >= gi, we can assign the cookie j to the child i,
 * and the child i will be content.
 * Your goal is to maximize the number of your content
 * children and output the maximum number.
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 * Example 1:
 * Input: [1,2,3], [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies.
 * The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1,
 * you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 * Input: [1,2], [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies.
 * The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length < 1 || g == null || g.length < 1) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int cookieLo = 0;
        int cookieHi = s.length - 1;
        for (int curChild = 0; curChild < g.length; ++curChild) {
            int foundCookie = findCookie(g[curChild], s, cookieLo, cookieHi);
            if (foundCookie < 0) {
                break;
            }
            cookieLo = foundCookie + 1;
            result++;
        }
        return result;
    }
    private int findCookie(int greed, int[] s, int siLo, int siHi) {
        if (siLo > siHi || greed > s[siHi]) {
            return -1;
        }
        if (greed <= s[siLo]) {
            return siLo;
        }
        while (siHi - siLo > 1) {
            int mid = (siHi + siLo) / 2;
            if (greed > s[mid]) {
                siLo = mid;
            } else {
                siHi = mid;
            }
        }
        if (s[siLo] < greed) {
            return siHi;
        }
        int found = siLo;
        while (found > 0 && s[found - 1] >= greed) {
            --found;
        }
        return found;
    }
}
