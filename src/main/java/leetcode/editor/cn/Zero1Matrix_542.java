package leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 536 👎 0


import leetcode.editor.cn.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Zero1Matrix_542 {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix_542().new Solution();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ret = solution.updateMatrix(mat);
        PrintUtils.print2DArray(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int[][] ret = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        ret[i][j] = 0;
                        continue;
                    }

                    boolean[][] used = new boolean[mat.length][mat[0].length];
                    ret[i][j] = bfs(mat, i, j, used, 0);
                }
            }
            return ret;
        }

        int bfs(int[][] mat, int x, int y, boolean[][] used, int stepCnt) {
            used[x][y] = true;
            if (mat[x][y] == 0) {
                return stepCnt;
            }

            List<Integer> nextNodes = new ArrayList<Integer>();
            if (x - 1 >= 0 && !used[x - 1][y]) {
                nextNodes.add(x - 1);
                nextNodes.add(y);
            }
            if (x + 1 < mat.length && !used[x + 1][y]) {
                nextNodes.add(x + 1);
                nextNodes.add(y);
            }
            if (y - 1 >= 0 && !used[x][y - 1]) {
                nextNodes.add(x);
                nextNodes.add(y - 1);
            }
            if (y + 1 < mat[0].length && !used[x][y + 1]) {
                nextNodes.add(x);
                nextNodes.add(y + 1);
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nextNodes.size(); i += 2) {
                if (stepCnt == bfs(mat, i, i + 1, used, stepCnt)) {
                    min = Math.min(stepCnt + 1, min);
                }
            }

            return Math.min(min, Integer.MAX_VALUE);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}