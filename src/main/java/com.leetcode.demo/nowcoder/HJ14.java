package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 华为机试  HJ14 字符串排序
 * https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&tqId=21237&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ14 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String[] ss = {"cap", "to", "cat", "card", "two", "too", "up", "boat", "boot"};
//        int n = Integer.parseInt(in.nextLine());
//        String[] ss = new String[n];
//        int i = 0;
//        while(in.hasNext() && i < n) {
//            ss[i++] = in.nextLine();
//        }
//        Arrays.sort(ss);
        String[] tmp = new String[ss.length];
        mergeSort(ss, tmp, 0, ss.length-1);
        for (String s : ss) {
            System.out.println(s);
        }
    }

    public static void mergeSort(String[] src, String[] tmp, int low, int high) {
        if (low >= high) return;

        int mid = low + ((high - low) >> 1);
        mergeSort(src, tmp, low, mid);
        mergeSort(src, tmp, mid+1, high);
        merge(src, tmp, low, mid, high);
    }
    private static void merge(String[] src, String[] tmp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            tmp[k++] = src[i].compareTo(src[j]) < 0 ? src[i++] : src[j++];
        }
        while (i <= mid) {
            tmp[k++] = src[i++];
        }
        while (j <= high) {
            tmp[k++] = src[j++];
        }

        for (i = 0; i < k; i++) {
            src[low+i] = tmp[i];
        }
    }
}
