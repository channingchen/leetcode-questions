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
// 👍 537 👎 0


import leetcode.editor.cn.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Zero1Matrix_542 {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix_542().new Solution();
//        int[][] mat = new int[5000][2];
//        for (int i = 0; i < 5000; i++) {
//            mat[i][0] = 0;
//            mat[i][1] = 1;
//        }
        int[][] mat = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        PrintUtils.print2DArray(mat);
        System.out.println();
        int[][] ret = solution.updateMatrix(mat);
        PrintUtils.print2DArray(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Pair {
        int x;
        int y;
        int currStep;
        int[][] mat;

        Pair(int x, int y, int[][] mat) {
            this.x = x;
            this.y = y;
            this.mat = mat;
        }

        boolean valid() {
            return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length);
        }

        int val() {
            return mat[x][y];
        }
    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int[][] ret = new int[mat.length][mat[0].length];
            Pair s = findFirstZeroAndInit(mat, ret);
            List<Pair> bfs = new ArrayList<Pair>();
            bfs.add(s);

            while (!bfs.isEmpty()) {
                List<Pair> list = new ArrayList<Pair>();

                for (Pair p : bfs) {
                    Pair u = new Pair(p.x - 1, p.y, mat);
                    Pair d = new Pair(p.x + 1, p.y, mat);
                    Pair l = new Pair(p.x, p.y - 1, mat);
                    Pair r = new Pair(p.x, p.y + 1, mat);

                    test(u, ret, list, p.currStep);
                }

                bfs = list;
            }
            return ret;
        }

        int test(Pair p, int[][] ret, List<Pair> bfs, int currStep) {
            if (p.valid() && ret[p.x][p.y] == -1) {
                if (p.val() == 0) {
                    ret[p.x][p.y] = 0;
                } else {
                    bfs.add(p);
                    return currStep + 1;
                }
            }
            return -1;
        }

        Pair findFirstZeroAndInit(int[][] mat, int[][] ret) {
            Pair zeroPos = null;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) zeroPos = new Pair(i, j, mat);
                    ret[i][j] = -1;
                }
            }
            return zeroPos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}