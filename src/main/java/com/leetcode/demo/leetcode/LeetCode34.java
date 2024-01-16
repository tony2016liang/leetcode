package com.leetcode.demo.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class LeetCode34 {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        // 先找左边界
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= 0 && left < nums.length && nums[left] == target) {
            res[0] = left;
        } else {
            res[0] = -1;
        }

        // 类似的方法找右边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right >= 0 && right < nums.length && nums[right] == target) {
            res[1] = right;
        } else {
            res[1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int target = 6;
        int[] res = searchRange(nums, target);
        System.out.println();
    }
}
