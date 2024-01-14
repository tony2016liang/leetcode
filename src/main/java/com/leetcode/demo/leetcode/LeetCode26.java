package com.leetcode.demo.leetcode;

/**
 * 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 */
public class LeetCode26 {

    public static int removeDuplicates(int[] nums) {
        int p = 0; // 定义指针 p 表示去重后达到的最新位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[++p] = nums[i];
            }
        }
        return p+1;
    }

    // 来自 labuladong 的双指针解法
    public static int removeDuplicates1(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int k = removeDuplicates1(nums);
        System.out.println(k);
    }
}
