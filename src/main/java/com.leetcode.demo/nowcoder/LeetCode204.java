package com.leetcode.demo.nowcoder;

import java.util.Arrays;

/**
 * 计数质数
 * https://leetcode.cn/problems/count-primes/
 */
public class LeetCode204 {

    /**
     * 之前对埃氏筛的理解有误：以为中间的 if 条件中的 isPrim[i] 为 true 仍然是要用传统方法判断是否是素数的，
     *      造成每次用传统方法判断素数到了一定大的 n 就会造成超时。
     * 而实际 埃氏筛 是不用像传统方法那样一个个地试过去能否整除的，这才是 埃氏筛 的牛逼之处，真的是找到了规律，
     * 按规律执行就可以筛出所有的素数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        return primes(n);
    }

    // 埃氏筛
    private int primes(int n) {
        int res = 0;
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);  // 先默认数组所有元素都是素数
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                res++;
                // j 取 i*i 作为初始值，是因为之前的数都处理过了
                if ((long) i * i < n) {  // 避免数组越界，多加一个判断
                    for (int j = i * i; j < n; j+=i) {
                        // 如果 i 是素数，则 i 所有的倍数都是合数
                        isPrim[j] = false;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        // 通过限制遍历次数进行优化
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode204 lc = new LeetCode204();
        long start = System.currentTimeMillis();
        int c = lc.countPrimes(499979);
        long cost = System.currentTimeMillis() - start;
        System.out.println(cost);
    }
}
