package com.leetcode.demo.leetcode;

/**
 * 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        if (slow != 0) {
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
