package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/
 */
public class LeetCode40 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i-1]) continue;
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i+1, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
