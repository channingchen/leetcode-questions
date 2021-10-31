package leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1628 👎 0


import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndOfList_19 {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList_19().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            Map<Integer, ListNode> map = new HashMap();
            Integer c = 0;
            for (ListNode i = head; i != null; i = i.next) {
                map.put(c, i);
                c++;
            }
            if (n == 1 && c == 1) {
                head = null;
            } else if (n == 1) {
                map.get(c - 2).next = null;
            } else if (n == c) {
                head = map.get(1);
            } else {
                map.get(c - n - 1).next = map.get(c - n + 1);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}