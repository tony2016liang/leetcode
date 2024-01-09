package com.leetcode.demo.leetcode;

import java.util.Arrays;

/**
 * 多数元素
 * https://leetcode.cn/problems/majority-element/description/
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        /**
         * 以下解法来自官解
         * 因为题目定义的多数元素就是出现次数大于 n/2 的元素，也就是出现次数要大于一半，那么如果存在这个多数元素，
         * 排序后的第 n/2 个元素就必然是众数之一，而且 n 是奇数或偶数并不影响这个结论。
         *
         * 不过这个解法虽然简洁，只有2行代码，但空间复杂度仍达不到 O(1)，因为系统默认的是快排或归并排序，如果要
         * 达到 O(1) 的空间复杂度，需要自己实现堆排序
         */
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 也是来自官解的 Boyer-Moore投票算法
     *
     *
     * 下面摘自一个精选评论（他的解释很生动好理解）：
     * 这是我目前看到的最直观形象的解法，时间复杂度O(n)，空间复杂度O(1)。
     *
     * “同归于尽消杀法” ：
     *
     * 由于多数超过50%, 比如100个数，那么多数至少51个，剩下少数是49个。
     *
     * 第一个到来的士兵，直接插上自己阵营的旗帜占领这块高地，此时领主 winner 就是这个阵营的人，现存兵力 count = 1。
     *
     * 如果新来的士兵和前一个士兵是同一阵营，则集合起来占领高地，领主不变，winner 依然是当前这个士兵所属阵营，现存兵力 count++；
     *
     * 如果新来到的士兵不是同一阵营，则前方阵营派一个士兵和它同归于尽。 此时前方阵营兵力count --。（即使双方都死光，这块高地的旗帜 winner 依然不变，因为已经没有活着的士兵可以去换上自己的新旗帜）
     *
     * 当下一个士兵到来，发现前方阵营已经没有兵力，新士兵就成了领主，winner 变成这个士兵所属阵营的旗帜，现存兵力 count ++。
     *
     * 就这样各路军阀一直以这种以一敌一同归于尽的方式厮杀下去，直到少数阵营都死光，那么最后剩下的几个必然属于多数阵营，winner 就是多数阵营。（多数阵营 51个，少数阵营只有49个，死剩下的2个就是多数阵营的人）
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int winner = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (winner == nums[i]) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return winner;
    }
}
