package com.leetcode.demo.test122324;

import java.util.*;

// 测试用例通过率 90%

/**
 * 输入两行：
 *  第一行是一个英文段落，其中包含大小写的单词和标点符号，将这里的单词作为字典（其中 don't 作为两个单词）
 *  第二行是一个单词的前缀，需要根据这个前缀到上面的字典中找符合要求的单词，然后按顺序输出
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        Set<String> sets = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        // 遍历并切割字母串，并放入TreeSet中实现排序
        for (int i = 0; i < words.length(); i++) {
            if (isLetter(words.charAt(i))) {
                sb.append(words.charAt(i));
            } else {
                if (sb.length() != 0) {
                    sets.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        String pre = in.nextLine();
        int count = 0;
        for (String s : sets) {
            if (s.startsWith(pre)) {
                count++;
                System.out.print(s + " ");
            }
        }
        if (count == 0) {
            System.out.println(pre);
        }
    }

    private static boolean isLetter(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
