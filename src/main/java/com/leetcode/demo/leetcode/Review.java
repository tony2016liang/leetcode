package com.leetcode.demo.leetcode;

import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

public class Review {

    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>(s.length());

        int left = 0, right = 0;
        int start = 0, len = Integer.MIN_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);

            while (window.contains(c)) {
                if (right - left > len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (window.contains(d)) {
                    window.remove(d);
                }
            }

            right++;

            if (!window.contains(c)) {
                window.add(c);
            }
        }

        return len == Integer.MIN_VALUE ? 0 : len;
    }



    public static void main(String[] args) {
        Review review = new Review();
        String s1 = "abcabcbb";
        int i1 = review.lengthOfLongestSubstring(s1);
        String s2 = "bbbbb";
        int i2 = review.lengthOfLongestSubstring(s2);
        String s3 = "pwwkew";
        int i3 = review.lengthOfLongestSubstring(s3);
        System.out.println();
    }
}


