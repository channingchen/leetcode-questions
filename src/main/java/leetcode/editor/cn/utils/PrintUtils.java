package leetcode.editor.cn.utils;

/**
 * @author chengming on 2021/11/3 5:08 下午
 */
public class PrintUtils {
    public static <T> void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
