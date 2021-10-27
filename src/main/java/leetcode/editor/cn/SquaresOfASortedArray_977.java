package leetcode.editor.cn;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 326 👎 0


import com.alibaba.fastjson.JSON;

public class SquaresOfASortedArray_977 {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray_977().new Solution();
        int[] arr = {-7, -3, 2, 2, 11};
        int[] ret = solution.sortedSquares(arr);
        System.out.println(JSON.toJSONString(ret));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int middle = 0;
            for (; middle < nums.length; middle++) {
                if (nums[middle] >= 0) {
                    break;
                }
            }

            int up = middle;
            int down = middle - 1;
            int[] ret = new int[nums.length];

            int addIndex = 0;
            while (up < nums.length || down >= 0) {
                int right = up < nums.length ? nums[up] * nums[up] : -1;
                int left = down >= 0 ? nums[down] * nums[down] : -1;

                if (down < 0) {
                    ret[addIndex] = right;
                    addIndex++;
                    up += 1;
                    continue;
                }
                if (up >= nums.length) {
                    ret[addIndex] = left;
                    addIndex++;
                    down -= 1;
                    continue;
                }

                if (right < left) {
                    ret[addIndex] = right;
                    up += 1;
                } else {
                    ret[addIndex] = left;
                    down -= 1;
                }
                addIndex++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}