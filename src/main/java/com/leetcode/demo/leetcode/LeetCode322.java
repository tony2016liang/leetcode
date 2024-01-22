package com.leetcode.demo.leetcode;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.cn/problems/coin-change/description/
 */
public class LeetCode322 {
    public static int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    /**
     * 思路：
     * 将金额的变化作为状态，满足每种金额所需要的最少硬币数作为需要的结果，定义一个 dp 函数
     * 1、base case: 当金额为 0 时，只需要 0 个硬币，所以返回 0
     * 2、当选择了一个硬币 c 后，子问题就变成了要拼凑出金额等于 amount-c 所需要的最少硬币数
     * 3、子问题返回值加 1 就是原问题的答案
     */
    private static int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = dp(coins, amount - coin);
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int coinChange1(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);  // 初始化 -2，以和 0、-1 区分
        return dpWithMemo(coins, amount, memo);
    }

    // 原 dp 方法在 leetcode 提交时会超时，以下方法在 dp 基础上再增加备忘录机制
    private static int dpWithMemo(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes;
            if (amount - coin < 0) {
                subRes = -1;
            } else if (memo[amount - coin] != -2) {
                subRes = memo[amount - coin];
            } else {
                subRes = dpWithMemo(coins, amount - coin, memo);
                memo[amount - coin] = subRes;
            }
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
            memo[amount] = res;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static int coinChange2(int[] coins, int amount) {
        return dpTable(coins, amount);
    }

    // 以上两种方法用的都是自顶向下的递归算法
    // 以下算法采用自底向上的迭代算法
    private static int dpTable(int[] coins, int amount) {
        // 定义一个 dp table，用来记录针对每种金额，所需要的最少的硬币数，
        // 因为最大下标是边界值 amount，所以数组元素需要多一个
        int[] dp = new int[amount + 1];
        // 将数组元素初始化为一个计算过程中不会出现的数值，便于之后的判断
        // 因为所需硬币数最大就是 amount，也就是硬币只有 1 元面值值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // 显然当金额为 0 时，所需的最少硬币数就是 0 个
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amout = 11;
        int i = coinChange2(coins, amout);
        System.out.println();
    }
}
