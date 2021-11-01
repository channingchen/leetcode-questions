package leetcode.editor.cn;

//有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。 
//
// 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。 
//
// 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方
//向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。 
//
// 最后返回经过上色渲染后的图像。 
//
// 示例 1: 
//
// 
//输入: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析: 
//在图像的正中间，(坐标(sr,sc)=(1,1)),
//在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，
//因为它不是在上下左右四个方向上与初始点相连的像素点。
// 
//
// 注意: 
//
// 
// image 和 image[0] 的长度在范围 [1, 50] 内。 
// 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。 
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 231 👎 0


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FloodFill_733 {
    public static void main(String[] args) {
        Solution solution = new FloodFill_733().new Solution();
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image = {{0, 0, 0}, {0, 1, 1}};

        int[][] newImg = solution.floodFill(image, 1, 1, 1);
        for (int i = 0; i < newImg.length; i++) {
            for (int j = 0; j < newImg[0].length; j++) {
                System.out.print(newImg[i][j] + " ,");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int old = image[sr][sc];
            boolean[][] used = new boolean[image.length][image[0].length];
            Set<Pos> set = new HashSet<Pos>();
            set.add(new Pos(sr, sc));

            while (set.size() > 0) {
                Set<Pos> s = new HashSet<Pos>();

                for (Pos pos : set) {
                    int x = pos.x;
                    int y = pos.y;
                    image[x][y] = newColor;

                    if (x - 1 >= 0 && !used[x - 1][y]) {
                        if (image[x - 1][y] == old) {
                            s.add(new Pos(x - 1, y));
                            image[x - 1][y] = newColor;
                            used[x - 1][y] = true;
                        }
                    }
                    if (x + 1 < image.length && !used[x + 1][y]) {
                        if (image[x + 1][y] == old) {
                            s.add(new Pos(x + 1, y));
                            image[x + 1][y] = newColor;
                            used[x + 1][y] = true;
                        }
                    }
                    if (y - 1 >= 0 && !used[x][y - 1]) {
                        if (image[x][y - 1] == old) {
                            s.add(new Pos(x, y - 1));
                            image[x][y - 1] = newColor;
                            used[x][y - 1] = true;
                        }
                    }
                    if (y + 1 < image[0].length && !used[x][y + 1]) {
                        if (image[x][y + 1] == old) {
                            s.add(new Pos(x, y + 1));
                            image[x][y + 1] = newColor;
                            used[x][y + 1] = true;
                        }
                    }
                }
                set = s;
            }
            return image;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}