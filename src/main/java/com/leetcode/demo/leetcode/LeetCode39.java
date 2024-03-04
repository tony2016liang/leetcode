package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 */
public class LeetCode39 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    Integer trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int index, int target) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        int[] nums = {1,2,3};
        int target = 7;
        List<List<Integer>> lists = leetCode39.combinationSum(nums, target);
        System.out.println();
    }
}
