package leetcode.editor.cn;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 12437 👎 0


import java.util.Arrays;

public class TwoSum_1 {
    public static void main(String[] args) {
        Solution solution = new TwoSum_1().new Solution();
        int[] arrs = {2, 4, 4, 9};
        int[] ret = solution.twoSum(arrs, 8);
        System.out.println(ret[0] + "," + ret[1]);
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            int[] old = Arrays.copyOf(nums, nums.length);
            Arrays.sort(nums);
            int s = 0;
            int e = nums.length - 1;
            while (s < e) {
                int sv = nums[s];
                int ev = nums[e];
                if (sv + ev < target) {
                    s += 1;
                    e = nums.length - 1;
                } else if (sv + ev > target) {
                    e -= 1;
                } else {
                    for (int i = 0; i < old.length; i++) {
                        if (old[i] == nums[s]) {
                            ret[0] = i;
                        }
                        if (old[i] == nums[e] && ret[0] != i) {
                            ret[1] = i;
                        }
                    }
                    return ret;

                }
            }
            return ret;

        }
    }

}