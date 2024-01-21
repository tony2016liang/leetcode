package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/
 * 括号的最大嵌套深度
 */
public class LeetCode1614 {

    public int maxDepth(String s) {
        int i = 0;
        int maxD = i;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            }
            if (c == ')') {
                i = st.size();
                if (i > maxD) {
                    maxD = i;
                }
                st.pop();
            }
        }
        return maxD;
    }
}
