package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1280 👎 0


import com.alibaba.fastjson.JSON;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes_283().new Solution();
        int[] arr = {0, 1};
        solution.moveZeroes(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int zi = 0;
            int zlen = 0;
            int nzi = 0;
            int nzlen = 0;
            int i = 0;
            while (i < nums.length) {
                if (nums[i] != 0) {
                    while (i < nums.length && nums[i] != 0) {
                        i++;
                        nzlen++;
                    }
                    nzi = i;
                } else {
                    while (i < nums.length && nums[i] == 0) {
                        i++;
                        zlen++;
                    }
                    zi = i;
                }

                if (nzi > 0 && zi > 0) {
                    if (zi < nzi) {
                        for (int j = nzi - nzlen; j < nzi; j++) {
                            nums[j - zlen] = nums[j];
                            nums[j] = 0;
                        }
                    }
                    nzlen = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}