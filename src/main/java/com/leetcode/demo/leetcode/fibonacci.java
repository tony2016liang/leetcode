package com.leetcode.demo.leetcode;

import java.util.Arrays;

public class fibonacci {

    // 记录一个自底向上计算Fibonacci数列值的算法
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);  // 先将数组元素初始化为 0
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 自顶向下带备忘录的递归方法
    public int fib1(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib2(memo, n);
    }

    private int fib2(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != -1) return memo[n];
        memo[n] = fib2(memo, n - 1) + fib2(memo, n - 2);
        return memo[n];
    }
}
