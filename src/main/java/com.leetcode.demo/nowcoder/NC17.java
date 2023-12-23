package com.leetcode.demo.nowcoder;

/**
 * NC17 最长回文子串
 * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=188&&tqId=38608&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC17 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A string字符串
     * @return int整型
     */
    public static int getLongestPalindrome (String A) {
        // write code here
        // 从最长子串开始遍历，逐渐减少子串长度，直到找到第一个回文子串
        int k = A.length();  // 子串长度
        while (k > 0) {
            for (int i=0; (i+k-1)<A.length(); i++) {
                if (palindrome(A, i, i+k-1)) return k;
            }
            k--;
        }
        return 0;
    }

    private static boolean palindrome(String s, int lo, int hi) {
        if (lo < 0 || hi >= s.length()) return false;
        if (lo == hi) return true;
        int i = lo, j = hi;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("ababc"));
        System.out.println(getLongestPalindrome("abbba"));
        System.out.println(getLongestPalindrome("b"));
    }
}
