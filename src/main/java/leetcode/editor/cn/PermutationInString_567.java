package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 476 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationInString_567 {
    public static void main(String[] args) {
        Solution solution = new PermutationInString_567().new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2));
    }

    class Old_Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, List<Integer>> m = new HashMap();
            for (int i = 0; i < s1.length(); i++) {
                List<Integer> l = m.get(s1.charAt(i));
                if (null == l) {
                    l = new ArrayList<Integer>();
                }
                l.add(i);
                m.put(s1.charAt(i), l);
            }


            long start = System.currentTimeMillis();
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                boolean[] used = new boolean[s1.length()];
                int j = i;

                start = System.currentTimeMillis();
                long interval = System.currentTimeMillis() - start;
                System.out.println(i + ": " + interval + "ms");

                jj:
                for (; j < i + s1.length(); j++) {
                    List<Integer> posList = m.get(s2.charAt(j));

                    if (null == posList) {
                        //这个字符在s1里面压根没有
                        i = j;
                        break;
                    }

                    boolean found = false;
                    for (int k = 0; k < posList.size(); k++) {
                        if (used[posList.get(k)]) {
                            continue;
                        }
                        used[posList.get(k)] = true;
                        found = true;
                        break;
                    }
                    if (found) continue;

                    //虽然在s1里面有，但是被用过了n次
                    //在s2中找到第n次这个字母的位置，从那之后开始找
                    int w = i;
                    while (true) {
                        if (s2.charAt(w) == s2.charAt(j)) {
                            i = w;
                            break jj;
                        }
                        w++;
                    }
                }

                if (j == i + s1.length()) {
                    return true;
                }
            }

            return false;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            if (len1 > len2) {
                return false;
            }

            //统计在s1中每个字符的数量
            int[] cnt = new int[26];
            for (int i = 0; i < len1; i++) {
                cnt[s1.charAt(i) - 'a']++;
            }

            int l = 0, r = 0;
            int windowSize = 0;
            while (r < len2) {
                if (--cnt[s2.charAt(r) - 'a'] >= 0) {
                    //窗口向右扩展，到此为止数量都匹配得上
                    if (++windowSize == len1) {
                        return true;
                    }
                } else {
                    //s2里面有字母数量超出了s1里面的数量，但目前只超出了1次
                    //于是从窗口左侧开始缩进窗口，逐步恢复之前的数组，直到将
                    // 这个仅多出来的1个恢复好，再继续往后。
                    while (cnt[s2.charAt(r) - 'a'] < 0) {
                        if (++cnt[s2.charAt(l++) - 'a'] > 0) {
                            windowSize--;
                        }
                    }
                }
                r++;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}