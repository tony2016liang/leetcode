package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * https://leetcode.cn/problems/subsets/description/
 */
public class LeetCode78 {
    List<List<Integer>> res = new ArrayList<>();
    // 用来保存选择的元素
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 要注意的是：这个递归的结束条件是隐形的，当 level == nums.length，
    // 也就是达到最深层时,for 循环就不再执行，也就会结束递归了
    private void backtrack(int[] nums, int level) {
        // 前序位置，每个节点都是一个子集
        res.add(new LinkedList<>(track));

        for (int i = level; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 进入下一次决策
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
