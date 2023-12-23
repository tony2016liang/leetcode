package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 组合
 * https://leetcode.cn/problems/combinations/
 *
 * FIXME leetcode未通过
 */
public class LeetCode77 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combine(int n, int k) {
        used = new boolean[n+1];
        backtrack(n, 0, k);
        return res;
    }

    private void backtrack(int n, int index, int k) {
        if (index == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=1; i<=n; i++) {
            if (used[i]) continue;
            temp.add(i);
            used[i] = true;
            System.out.println(" 递归前：" + temp);
            backtrack(n, index+1, k);
            temp.remove(index);
            used[i] = false;
            System.out.println("递归后：" + temp);
        }
    }

    public static void main(String[] args) {
        LeetCode77 lc = new LeetCode77();
        List<List<Integer>> combine = lc.combine(4, 2);
        System.out.println(combine);
    }
}
