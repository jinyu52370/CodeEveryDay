package oj.leetcode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/6 10:39
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。
 * 字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 *  s = "abc", t = "ahbgdc"
 *  返回true.
 *
 * 示例 2:
 *  s = "axc", t = "ahbgdc"
 *  返回false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class Q392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t) || s.length() == 0) {
            return true;
        }
        for (char c : s.toCharArray()) {
            if (!t.contains(String.valueOf(c))) {
                return false;
            }
            int index = t.indexOf(String.valueOf(c));
            t = t.substring(index + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q392_判断子序列().isSubsequence("aaaaaa", "bbaaaa"));
    }
}
