package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example
 * to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges,
 * not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseScheduleTest {
    @Test(dataProvider="courseGen")
    public void testCourseSchedule(int numCourses, int[][] prerequisites, boolean expected) {
        CourseSchedule sut = new CourseSchedule();
        boolean actual = sut.canFinish(numCourses, prerequisites);
        String tag = String.format("%d %s", numCourses, aaiStr(prerequisites));
        Assert.assertEquals(actual, expected, tag);
    }
    @DataProvider(name="courseGen")
    public Object[][] courseGen() {
        Object[][] cases = {
            {1, new int[][]{
                new int[]{1,0}
            }, true},
            {2, new int[][]{
                new int[]{1,0},
                new int[]{0,1}
            }, false},
            {3, new int[][]{
                new int[]{0,1},
                new int[]{0,2},
                new int[]{1,2}
            }, true},
            {65536, new int[][]{}, true},
            {3, new int[][]{
                new int[]{0,1},
                new int[]{0,2},
                new int[]{1,2},
                new int[]{2,0}
            }, false},
            {4, new int[][]{
                new int[]{0,1},
                new int[]{1,2},
                new int[]{4,4}
            }, true}
        };
        return cases;
    }
    private String aaiStr(int[][] aai) {
        String r = aStr(aai, (int[] ai)->aiStr(ai));
        return r;
    }
    private String aiStr(int[] ai) {
        Integer[] aI = Arrays.stream(ai).boxed().toArray(Integer[]::new);
        String r = aStr(aI, (n)->Integer.toString(n));
        return r;
    }
    private <T> String aStr(T[] a, Function<T,String> toStr) {
        StringBuffer buf = new StringBuffer("[");
        if (a != null && a.length > 0) {
            for (int i = 0; i < a.length; ++i) {
                if (i > 0) {
                    buf.append(",");
                }
                buf.append(toStr.apply(a[i]));
            }
        }
        buf.append("]");
        return buf.toString();
    }
}
