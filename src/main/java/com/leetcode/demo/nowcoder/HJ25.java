package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 数据分类处理
 * https://www.nowcoder.com/practice/9a763ed59c7243bd8ab706b2da52b7fd?tpId=37&tqId=21248&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ25 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] I = new int[n1];
        for (int i=0; i<n1; i++) {
            I[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] R = new int[n2];
        for (int i=0; i<n2; i++) {
            R[i] = in.nextInt();
        }
        Set<Integer> treeSet = new TreeSet<>();
        for (int r : R) {
            treeSet.add(r);
        }
        Integer[] RR = treeSet.toArray(new Integer[0]);

    }
}
