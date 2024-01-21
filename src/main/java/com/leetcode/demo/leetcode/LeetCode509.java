package com.leetcode.demo.leetcode;

/**
 * 斐波那契数列
 * https://leetcode.cn/problems/fibonacci-number/description/
 */
public class LeetCode509 {
    // 最简单的
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // 带备忘录的
    public int fib1(int n) {
        int[] memo = new int[n + 1];
        return fib11(n, memo);
    }
    private int fib11(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] == 0) {
            memo[n] = fib11(n - 1, memo) + fib11(n - 2, memo);
        }
        return memo[n];
    }

    // 动态规划（迭代，非递归）
    public int fib2(int n) {
        if (n == 0 || n  == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 一种更省内存的动态规划
    public int fib3(int n) {
        if (n == 0 || n  == 1) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = temp;
        }
        return dp[1];
    }
}
