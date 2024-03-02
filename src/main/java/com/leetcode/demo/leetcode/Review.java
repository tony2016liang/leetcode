package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Review {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(track));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Review review = new Review();
        int[] nums = {1,2,2};
        review.subsetsWithDup(nums);
        System.out.println();
    }
}


