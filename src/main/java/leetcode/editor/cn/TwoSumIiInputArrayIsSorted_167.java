package leetcode.editor.cn;

//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。 
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
// 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 104 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 606 👎 0


import com.alibaba.fastjson.JSON;

public class TwoSumIiInputArrayIsSorted_167 {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted_167().new Solution();
        int[] arr = new int[26020];
        for (int i = 0; i < 13010; i++) {
            arr[i] = 0;
        }
        arr[13010] = 2;
        arr[13011] = 3;
        for (int i = 13012; i < 26020; i++) {
            arr[i] = 9;
        }
//        int[] arr = {0, 0, 0, 0, 0, 2, 3, 9, 9, 9};
        long start = System.currentTimeMillis();
        int[] ret = solution.twoSum(arr, 5);
        long time = System.currentTimeMillis() - start;

        System.out.println(time + "ms, " + JSON.toJSONString(ret));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[]{-1, -1};
            int s, e;
            for (s = 0; s < nums.length; s++) {
                int es = 0;
                int ee = nums.length - 1;
                int lastTarget = target;
                while (es <= ee) {
                    e = (es + ee) / 2;
                    int sv = nums[s];
                    int ev = nums[e];

                    if (sv + ev < target) {
                        es = ee - es == 1 ? ee : e;
                    } else if (sv + ev > target) {
                        ee = ee - es == 1 ? es : e;
                    } else {
                        if (s != e) {
                            return new int[]{Math.min(s + 1, e + 1), Math.max(s + 1, e + 1)};
                        }
                    }

                    if (sv + ev == lastTarget || ev - sv <= 1) {
                        break;
                    } else {
                        lastTarget = sv + ev;
                    }
                }
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}