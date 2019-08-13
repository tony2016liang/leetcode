package com.leetcode.demo.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidBracket {

    public static boolean isValid(String s) {
        String[] ss = s.split("");
        Stack stack = new Stack();
        for (int i=0; i<ss.length; i++) {
            switch (ss[i]) {
                case "(":
                case "{":
                case "[":
                    stack.push(ss[i]);
                    break;
                case ")":
                case "}":
                case "]": {
                    if (stack.empty()) {
                        return false;
                    }
                    if ((stack.peek().equals("(") && ss[i].equals(")"))
                        || (stack.peek().equals("[") && ss[i].equals("]"))
                        || (stack.peek().equals("{") && ss[i].equals("}"))) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                }
                default:
                    break;
            }
        }
        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "((()))";
        String s3 = "))((";
        String s4 = "{[]}";
        String s5 = "(((";

        boolean b1 = isValid(s1);
        boolean b2 = isValid(s2);
        boolean b3 = isValid(s3);
        boolean b4 = isValid(s4);
        boolean b5 = isValid(s5);
        System.out.println();
    }
}
