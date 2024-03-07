package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Review {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "" == s) {
            return 0;
        }
        List<Character> window = new ArrayList<>();
        int left = 0, right = 0, len = 0;
        while (left <= right && right < s.length()) {
            window.add(s.charAt(right));
            right++;
            len++;
        }

        return 0;
    }



    public static void main(String[] args) {
        Review review = new Review();

    }
}


