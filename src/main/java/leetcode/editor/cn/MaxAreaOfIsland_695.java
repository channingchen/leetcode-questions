package leetcode.editor.cn;

//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 584 👎 0


public class MaxAreaOfIsland_695 {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland_695().new Solution();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            boolean[][] used = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (used[i][j] || grid[i][j] == 0) continue;

                    int a = area(grid, i, j, used);
                    max = Math.max(max, a);
                }
            }
            return max;
        }

        private int area(int[][] grid, int x, int y, boolean[][] used) {
            if (grid[x][y] == 0) return 0;
            int a = 1;
            used[x][y] = true;
            a += direct(x - 1, y, grid, used);
            a += direct(x + 1, y, grid, used);
            a += direct(x, y - 1, grid, used);
            a += direct(x, y + 1, grid, used);
            return a;
        }

        private int direct(int x, int y, int[][] grid, boolean[][] used) {
            int a = 0;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;

            if (grid[x][y] == 1 && !used[x][y]) {
                used[x][y] = true;

                a += area(grid, x, y, used);
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}