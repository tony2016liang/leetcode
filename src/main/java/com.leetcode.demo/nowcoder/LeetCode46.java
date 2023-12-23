package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        invoke(nums, n, 0, used, temp, res);
        return res;
    }

    private void invoke(int[] nums, int n, int depth, boolean[] used,
                        List<Integer> temp, List<List<Integer>> res) {
        if (depth == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<n; i++) {
            if (used[i]) continue;
            temp.add(nums[i]);
            used[i] = true;
            invoke(nums, n, depth+1, used, temp, res);
            temp.remove(depth);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LeetCode46 lc = new LeetCode46();
        List<List<Integer>> permute = lc.permute(nums);
        System.out.println(permute);
    }
}
