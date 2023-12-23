package com.leetcode.demo.nowcoder;

/**
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
 * 最长连续递增序列
 */
public class LeetCode674 {

    public static int findLengthOfLCIS(int[] nums) {
        int l = 1;
        int max = l;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                max = Math.max(max, l);
                l = 1;
                continue;
            }
            l++;
        }
        return Math.max(max, l);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
