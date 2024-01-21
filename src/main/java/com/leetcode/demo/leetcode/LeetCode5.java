package com.leetcode.demo.leetcode;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class LeetCode5 {

    // 以下为来自 labuladong 的解法
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 先以i点为中心，计算最长回文串
            String sub1 = palindrome(s, i, i);
            // 再以 i 和 i+1 为中心，计算最长回文串
            String sub2 = palindrome(s, i, i + 1);

            res = res.length() > sub1.length() ? res : sub1;
            res = res.length() > sub2.length() ? res : sub2;
        }
        return res;
    }

    // 寻找以 s[l] s[r] 为中心向外扩散的回文串
    // 其中如果 l == r 表示从一个中心向外扩，得到的回文串字符数为奇数
    // 否则 l 和 r 则必须是相邻的下标
    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
