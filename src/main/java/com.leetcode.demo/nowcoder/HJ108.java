package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 华为机试 HJ108 求最小公倍数
 * https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&tqId=21331&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ108 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int max = Math.max(a, b);
        int mul = a * b;
        if (mul == max) System.out.println(max);
        for (int i=max; i<=mul; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println(i);
                return;
            }
        }
    }
}
