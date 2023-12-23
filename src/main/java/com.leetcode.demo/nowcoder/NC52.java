package com.leetcode.demo.nowcoder;

import java.util.Stack;

/**
 * 华为机试 NC52 有效括号序列
 * https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?...
 */
public class NC52 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        if (s.length() < 2 || s.length() % 2 != 0) {
            return false;
        }
        Stack<String> st = new Stack<>();
        for (String ss : s.split("")) {
            switch (ss) {
                case "{":
                case "(":
                case "[":
                    st.push(ss);
                    break;
                case "}":
                    if (st.peek().equals("{")) {
                        st.pop();
                        break;
                    } else {
                        return false;
                    }
                case ")":
                    if (st.peek().equals(")")) {
                        st.pop();
                        break;
                    } else {
                        return false;
                    }
                case "]":
                    if (st.peek().equals("]")) {
                        st.pop();
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        return st.isEmpty();
    }
}
