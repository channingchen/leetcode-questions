package leetcode.editor.cn;

//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 580 👎 0


import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointersInEachNode_116 {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode_116().new Solution();
        Node[] n = new Node[7];
        for (int i = 0; i < n.length; i++) {
            n[i] = new Node(i + 1);
        }
        for (int i = 0; i < n.length / 2; i++) {
            n[i].left = n[i * 2 + 1];
            n[i].right = n[i * 2 + 2];
        }

        solution.connect(n[0]);
        for (int i = 0; i < n.length; i = i * 2 + 1) {
            Node node = n[i];
            System.out.print(node.val);
            while (null != node.next) {
                node = node.next;
                System.out.print(node.val);
            }
            System.out.println("#");
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            List<Node> l;
            List<Node> nodes = new ArrayList<Node>();
            nodes.add(root);
            do {
                l = f(nodes);
                for (int i = 0; i < l.size() - 1; i++) {
                    l.get(i).next = l.get(i + 1);
                }
                nodes = l;
            } while (nodes.size() > 0);

            return root;
        }

        private List<Node> f(List<Node> nodes) {
            List<Node> ret = new ArrayList<Node>();
            for (int i = 0; i < nodes.size(); i++) {
                if (null == nodes.get(i).left) break;
                ret.add(nodes.get(i).left);
                ret.add(nodes.get(i).right);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}