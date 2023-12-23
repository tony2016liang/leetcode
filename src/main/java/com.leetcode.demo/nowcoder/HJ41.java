package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 华为机试 HJ41 称砝码
 * https://www.nowcoder.com/practice/f9a4c19050fc477e9e27eb75f3bfd49c?tpId=37&tqId=21264&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());  // 砝码有多少种类
        // 以下是 n 种砝码的分别的重量
        Integer[] weight = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);
        // 以下是 n 种砝码对应以上重量的各自的数量
        Integer[] num = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Set<Integer> sets = new HashSet<>();  // 存放最后总的重量种类
        sets.add(0);  // 都不选的时候，默认是0
        // 三重循环
        // 1、先遍历每一种砝码
        for (int i=0; i<n; i++) {
            // 定义一个包含 sets 所有元素的新 list 列表，从来存储针对这种砝码的各种组合情况
            List<Integer> list = new ArrayList<>(sets);
            // 2、再根据该种砝码的数量从 1 开始遍历，表示选了多少个
            for (int j=1; j<=num[i]; j++) {
                // 3、遍历 sets 集合
                for (int k=0; k<list.size(); k++) {
                    sets.add(list.get(k) + weight[i] * j);
                }
            }
        }
        System.out.println(sets.size());
    }
}
