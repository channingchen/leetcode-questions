package leetcode.editor.cn;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 
// 👍 1169 👎 0


import com.alibaba.fastjson.JSON;

public class RotateArray_189 {
    public static void main(String[] args) {
        Solution solution = new RotateArray_189().new Solution();
        int[] arr = {1};
        solution.rotate(arr, 3);
        System.out.println(JSON.toJSONString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //TODO NOT SO GOOD
    class Solution {
        public void rotate(int[] nums, int k) {
            if (k > nums.length) {
                k = k % nums.length;
            }
            int[] temp = new int[k];
            for (int i = nums.length - k; i < nums.length; i++) {
                temp[i - nums.length + k] = nums[i];
            }
            for (int j = nums.length - k - 1; j >= 0; j--) {
                nums[j + k] = nums[j];
            }
            for (int w = 0; w < k; w++) {
                nums[w] = temp[w];
            }
        }
//    class Solution {
//        public void rotate(int[] nums, int k) {
//            int start = 0, end = nums.length;
//            int segmentLen = end - start;
//
//            boolean right = true;
//            while (segmentLen > 1) {
//                int subStart, subEnd;
//                int subLen;
//                if (segmentLen - k == 0) {
//                    break;
//                }
//                if (segmentLen - k > k) {
//                    subStart = end - k;
//                    subEnd = end;
//                } else {
//                    subStart = start;
//                    subLen = (segmentLen - k);
//                    subEnd = start + subLen;
//                    right = false;
//                    k = subLen;
//                }
//
//
//                swapSegment(nums, start, end, subStart, subEnd);
//                if (right) {
//                    start = start + (subEnd - subStart);
//                } else {
//                    end = end - (subEnd - subStart);
//                }
//                segmentLen = end - start;
//                right = !right;
//            }
//        }
//
//        //在nums[s:e)中，交换nums[subStart:subEnd)的位置，其中，要么subStart=s，要么subEnd=e
//        //e.g. [0,0,0,1,2,3,4,5,0,0,0] ->
//        // s=3,e=8,subStart=3,subEnd=5 ->
//        // [0,0,0,4,5,3,1,2,0,0,0]
//        private void swapSegment(int[] nums, int s, int e, int subStart, int subEnd) {
//            int move = (e - s) - (subEnd - subStart);
//            for (int i = subStart; i < subEnd; i++) {
//                swap(nums, i, i + move > e ? i - move : i + move);
//            }
//        }
//
//        private void swap(int[] nums, int index1, int index2) {
//            int a = nums[index1];
//            nums[index1] = nums[index2];
//            nums[index2] = a;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}