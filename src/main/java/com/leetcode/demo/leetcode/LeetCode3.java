package com.leetcode.demo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> window = new LinkedList<>();
        int left = 0, right = 0;
        int len = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            while (window.contains(c)) {
                if (right - left > len) {
                    len = right - left;
                }
                Character d = window.poll();
                left++;
            }
            right++;
            window.add(c);
        }

        // 考虑到 s 中的所有字符都是不重复的，则上面代码的内部 while 循环是进不去的
        if (!window.isEmpty() && window.size() > len) {
            len = window.size();
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "ynyo";
        int len = lengthOfLongestSubstring(s);
        System.out.println();
    }
}
