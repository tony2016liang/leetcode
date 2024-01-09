package com.leetcode.demo.leetcode;

/**
 * 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/
 */
public class LeetCode41 {

    public static int firstMissingPositive(int[] nums) {
        /**
         * 以下解法来自官解：
         *
         * 这里有一个前提：就是对于长度为 n 的 nums 数组，缺失的第一个整数一定在 [1, n+1] 区间
         *
         * 为了达到题目要求的 O(n) 的时间复杂度和 O(1) 的空间复杂度，本解法的思路是用数组自身的
         * 下标来标识数组中包含的小于等于 n 的正整数。
         *
         * 具体做法是先将数组中的所有非正数设置成一个比 n 大的数，这里是设置为了 n + 1；然后再遍历
         * 数组，将其中小于等于 n 的正整数所对应下标处的值设置为当前数的负数（考虑到数组中有重复元素，
         * 所以设置负数的时候需要先取绝对值，再取负）；最后再遍历数组，找第一个正整数，则缺失的第一个
         * 正数就是这个下标加 1.如果以上都未取到值，则最终结果就是 n + 1
         */
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n)
                nums[num - 1] = - Math.abs(nums[num - 1]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        // 如果遍历完整个数组都没有正数，说明数组中恰好包含整个 [1, n] 区间的数，
        // 那么缺失的最小正数就是 n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
//        int[] nums = {3,4,-1,1};
//        int[] nums = {7,8,9,11,12};
        int r = firstMissingPositive(nums);
        System.out.println(r);
    }
}
