package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 组合
 * https://leetcode.cn/problems/combinations/
 *
 */
public class LeetCode77 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> t = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 0, k);
        return res;
    }

    private void backtrack(int n, int index, int k) {
        if (t.size() == k) {
            res.add(new ArrayList<>(t));
        }
        for (int i = index; i < n; i++) {
            t.addLast(i + 1);
            System.out.println("递归前：" + t);
            backtrack(n, i + 1, k);
            t.removeLast();
            System.out.println("递归后：" + t);
        }
    }

    public static void main(String[] args) {
        LeetCode77 lc = new LeetCode77();
        List<List<Integer>> combine = lc.combine(4, 2);
        System.out.println(combine);
    }
}
