package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * You are given a map in form of a two-dimensional integer grid
 * where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * Example:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * https://leetcode.com/static/images/problemset/island.png
 */
public class IslandPerimeterTest {
    @Test(dataProvider="islandGen")
    public void testIsland(int[][] grid, int expected) {
        IslandPerimeter sut = new IslandPerimeter();
        int actual = sut.islandPerimeter(grid);
        Assert.assertEquals(actual, expected);
    }
    @DataProvider(name="islandGen")
    public Object[][] islandGen() {
        Object[][] cases = {
            {
                new int[][]{
                    new int[]{0, 1, 0, 0},
                    new int[]{1, 1, 1, 0},
                    new int[]{0, 1, 0, 0},
                    new int[]{1, 1, 0, 0}
                }, 16
            },
            {
                new int[][]{
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 1, 0, 0},
                    new int[]{0, 0, 0, 0}
                }, 4
            },
            {
                new int[][]{
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 1, 1, 0},
                    new int[]{0, 0, 0, 0}
                }, 6
            },
            {
                new int[][]{
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 1, 1, 0},
                    new int[]{0, 1, 1, 0}
                }, 8
            },
            {
                new int[][]{
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 0, 0, 0},
                    new int[]{0, 1, 1, 1}
                }, 8
            }
        };
        return cases;
    }
}
