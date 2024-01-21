package com.leetcode.demo.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,7,4,8,6};
        quickSort2(arr, 0, arr.length-1);
        System.out.println();
    }

    private static void quickSort1(int[] arr, int low, int high) {
        if (low >= high) return;
        // 定义四个变量，分别是低位指针、高位指针、基准数和临时变量
        // 基准数默认左侧第一位
        int i = low, j = high, base = arr[low], tmp;
        // 每一轮的遍历，都是要将数组按照基准数的大小分成两类
        // 比基准数小的放到左侧，比基准数大的放到右侧
        while (i < j) {
            // 先从右向左扫描，直到找比base小的数，且要保证j指针不越过i指针
            // 之所以先从右开始扫描，是因为我们将左侧第一位默认成了基准数
            while (arr[j] >= base && i < j) {
                j--;
            }
            // 再从左向右扫描，直到找比base大的数，仍要保证i不能越过j
            while (arr[i] <= base && i < j) {
                i++;
            }
            // 交换 arr[i] 和 arr[j]
            if (i < j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        // 一轮遍历完之后，交换 arr[i] 和 基准数的值
        // 这里为什么交换的是 arr[i] 而不是 arr[j] ？ 等会可以测试看看
        arr[low] = arr[i];
        arr[i] = base;

        // 分别递归执行基准数左右两侧的数组
        quickSort1(arr, low, j-1);
        quickSort1(arr, j+1, high);
    }

    private static void quickSort2(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition(arr, lo, hi);
        quickSort2(arr, lo, p-1);
        quickSort2(arr, p+1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi;
        int base = arr[lo];
        int t;
        while (i < j) {
            while (base <= arr[j] && i < j) {
                j--;
            }
            while (base >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[lo] = arr[i];
        arr[i] = base;
        return i;
    }
}
