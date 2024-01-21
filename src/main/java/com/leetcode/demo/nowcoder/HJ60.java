package com.leetcode.demo.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 华为机试 HJ60 查找组成一个偶数最接近的两个素数
 * https://www.nowcoder.com/practice/f8538f9ae3f1484fb137789dec6eedb9?tpId=37&tqId=21283&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ60 {

    // 用于预加载1000以内的素数
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) {
        // 验证二分查找最接近元素
//        Integer[] nums = {1,3,5,6,8,10,15,21,50,100};
//        List<Integer> list = Arrays.asList(nums);
//        System.out.println(biSearchClosest(list, 6));
//        System.out.println(biSearchClosest(list, 7));
//        System.out.println(biSearchClosest(list, 9));
//        System.out.println(biSearchClosest(list, 14));
//        System.out.println(biSearchClosest(list, 16));

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 根据题意，n 是偶数
        // 先预加载1000以内的素数
        for (int i=2; i<1000; i++) {
            if (isPrime(i)) primeList.add(i);
        }
        int[] res = new int[2];  // 用于保存最后结果
        int min = Integer.MAX_VALUE;
        for (int i=0; i<1000 && primeList.get(i)<=n; i++) {
            // 如果 n 和当前元素的差也是素数，且二者之差小于 min，则保存两个元素，且更新 min
            int cur = primeList.get(i);
            if (primeList.contains(n - cur) && (Math.abs(n - 2 * cur) < min)) {
                min = Math.abs(n - 2 * cur);
                res[0] = cur;
                res[1] = n - cur;
            }
        }
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    // 判断是否为素数
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i=2; i<n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 查找 list 中最接近给定数值的元素，返回的是下标
    private static int biSearchClosest(List<Integer> list, int n) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (n > list.get(mid)) {
                left = mid + 1;
            } else if (n < list.get(mid)) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        // 如果没找到匹配的元素，则从 left 和 right 中找最接近的
        if (Math.abs(n - list.get(left)) > Math.abs(n - list.get(right))) {
            return right;
        } else {
            return left;
        }
    }
}
