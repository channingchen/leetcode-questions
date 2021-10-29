package leetcode.editor.cn;

//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 349 👎 0


public class ReverseWordsInAStringIii_557 {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii_557().new Solution();
        String str = "let's do it again";
        System.out.println(solution.reverseWords(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String str) {
            int b = 0;
            char[] s = str.toCharArray();
            for (int i = 0; i < s.length; i++) {
                if (s[i] == ' ' || i == s.length - 1) {
                    reverseWord(s, b, i == s.length - 1 ? i : i - 1);
                    b = i + 1;
                }
            }
            return new String(s);
        }

        //[b,e)
        public void reverseWord(char[] s, int b, int e) {
            for (int i = b; i < b + (e - b) / 2 + 1; i++) {
                if (s[i] == s[e - (i - b)]) {
                    continue;
                } else {
                    char t = s[i];
                    s[i] = s[e - (i - b)];
                    s[e - (i - b)] = t;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}