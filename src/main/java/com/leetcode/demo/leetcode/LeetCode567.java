package com.leetcode.demo.leetcode;

import java.util.HashMap;

/**
 * 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/description/
 */
public class LeetCode567 {

    /**
     * 思路：
     * 运用滑动窗口的思想，left 左指针不断右移探查 s1 包含的字符，match后 right 右指针
     * 从当前位置继续右移探查，直到遇到不在 s1 中的字符，然后比较 [left, right) 区间的
     * 子串是否是 s1 的排列，如果是，直接返回 true；如果不是，left 左指针从这个位置继续
     * 向右探查，重复以上步骤
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                Character d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        boolean b = checkInclusion(s1, s2);
        System.out.println();
    }

}
