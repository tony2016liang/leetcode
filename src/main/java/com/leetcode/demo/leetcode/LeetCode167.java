package com.leetcode.demo.leetcode;

/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class LeetCode167 {

    // numbers 是一个下标从 1 开始的非递减数组
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int index = binarySearch(numbers, target - numbers[i]);
            if (index != -1 && index != i) {
                res[0] = Math.min(index, i) + 1;
                res[1] = Math.max(index, i) + 1;
            }
        }
        return res;
    }

    private static int binarySearch(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 上面是比较暴力的解法
    // 下面是来自 labuladong 的比较简洁的双指针解法
    public static int[] twoSum1(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
