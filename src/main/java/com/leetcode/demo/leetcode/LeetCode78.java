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


    List<List<Integer>> ans = new ArrayList<>();  // 存储最终结果
    LinkedList<Integer> t = new LinkedList<>();  // 存储每次得到的子集
    /**
     * 来自官解，加了些注释：
     *
     * 大致思路：想象一个 nums.length 位的二进制数，其中 0 位表示 nums 中该位置的元素不在子集中，1 位则表示在子集中，
     * 例如对于 nums = [1,2,3], 有 000=[], 111=[1,2,3], 101=[1,3], 110=[1,2]，以此类推，会发现 nums 的所有
     * 子集所对应的二进制数恰好在 0 ~ (2^n)-1 之间
     * 也就是对于 n 个元素的数组，只要找到 0 ~ (2^n)-1 之间的所有二进制数，然后根据以上规律生成相应的子集，则遍历完所
     * 有的二进制数得到的就是全部的子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();  // 每一轮开始前先清空 t
            // 遍历 nums
            for (int i = 0; i < n; i++) {
                /**
                 * 判断 mask 在该位置的 bit 数是 0 还是 1
                 *
                 * 这里的算法简单解释：
                 * 1 的二进制数中除了最后一位是 1，其他位都是 0，通过将最后一位的 1 不断向左移，然后再与 mask 做 & 操作，
                 * 就可以根据操作结果知道 mask 的相应位置是不是 1
                 *
                 * 这个算法有个缺陷，就是 1 作为 int 类型，只有四个字节32位，也就是只能计算 nums 的长度小于等于 32 的数组，
                 * 再长的话就要考虑用 long 型的 1，或更长的数据类型
                 * 不过这个题目的条件是 nums 的长度不大于 10，所以这个解法对于这个题目是 ok 的
                 */
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

}
