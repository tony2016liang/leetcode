package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 * https://leetcode.cn/problems/subsets-ii/description/
 */
public class LeetCode90 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 由于数组有重复元素，为了便于后面遍历时根据重复元素进行剪枝，需要先排序
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        res.add(new LinkedList<>(track));
        for (int i = index; i < nums.length; i++) {
            // 相邻的重复元素不处理
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode90 leetCode90 = new LeetCode90();
        int[] nums = {1};
        List<List<Integer>> lists = leetCode90.subsetsWithDup(nums);
        System.out.println();
    }
}
