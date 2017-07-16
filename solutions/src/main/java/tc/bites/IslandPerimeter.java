package tc.bites;

import java.util.HashSet;
import java.util.Set;

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
public class IslandPerimeter {
    private static final int[] DELTAS = new int[]{-1, 1};
    public int islandPerimeter(int[][] grid) {
        Set<Integer> visited = new HashSet<>();
        int[] startCell = findStart(grid);
        int perimeter = findPerimeter(visited, grid, startCell[0], startCell[1]);
        return perimeter;
    }
    private int findPerimeter(Set<Integer> visited, int[][] grid, int row, int col) {
        int perimeter = 0;
        if (grid[row][col] != 0) {
            visited.add(cantor(row, col));
            for (int dr: DELTAS) {
                int r = row + dr;
                if (r < 0 || r >= grid.length) {
                    perimeter += 1;
                } else if (grid[r][col] == 0) {
                    perimeter += 1;
                } else if (! visited.contains(cantor(r, col))) {
                    perimeter += findPerimeter(visited, grid, r, col);
                }
            }
            for (int dc: DELTAS) {
                int c = col + dc;
                if (c < 0 || c >= grid[0].length) {
                    perimeter += 1;
                } else if (grid[row][c] == 0) {
                    perimeter += 1;
                } else if (! visited.contains(cantor(row, c))) {
                    perimeter += findPerimeter(visited, grid, row, c);
                }
            }
        }
        return perimeter;
    }
    private int cantor(int k1, int k2) {
        int result = (k1 + k2) * (k1 + k2 + 1) / 2 + k2;
        return result;
    }
    private int[] findStart(int[][] grid) {
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                if (grid[row][col] != 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }
}
