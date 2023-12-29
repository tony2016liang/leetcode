package com.leetcode.demo.test122324;

import java.util.*;
import java.util.stream.Collectors;

// 只成功了45%的测试用例，其他就都超时了

/**
 * 给一个正整数 num，在 0-num 间找两个素数，使其成绩等于 num，有则输出这两个素数，没有则返回 （-1，-1）
 */
public class Test02 {

    public static void main(String[] args) {
//        Scanner in  = new Scanner(System.in);
//        int num = in.nextInt();  // 待分解正整数
        int num = 15;  // 待分解正整数
        int[] res = {-1, -1};  // 待输出的两个素数
        // 先用埃氏筛找出 2~num 间的所有素数
        int[] primes = new int[num];
        Arrays.fill(primes, 1);
        for (int i = 2; i * i < num; i++) {
            if (primes[i] == 1 && isPrime(i)) {
                for (int j = i * i; j < num; j += i) {
                    primes[j] = 0;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 1) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) * list.get(j) == num) {
                    res[0] = list.get(i);
                    res[1] = list.get(j);
                }
            }
        }
        System.out.println(Math.min(res[0], res[1]) + " " + Math.max(res[0], res[1]));
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
