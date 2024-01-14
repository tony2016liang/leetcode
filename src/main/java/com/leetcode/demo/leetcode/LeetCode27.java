package com.leetcode.demo.leetcode;

/**
 * 移除元素
 * https://leetcode.cn/problems/remove-element/description/
 */
public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int len = 0;
        for (int i = 0, j = n - 1; i <= j;) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
            if (i == j) {
                // 这里考虑最后一个元素如果等于val，则该元素也是要被删除的，
                // 则返回的数组就不应该包含这个元素，否则则要包含在内
                len = (nums[i] == val ? i : i + 1);
            }
            // 考虑全数组都不用删除的情况
            if (i >= nums.length) {
                len = n;
            }

        }
        return len;
    }

    public static int removeElement1(int[] nums, int val) {
        // 来自 labuladong 的更巧妙的双指针法
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int k = removeElement(nums, 3);
        System.out.println();
    }
}
