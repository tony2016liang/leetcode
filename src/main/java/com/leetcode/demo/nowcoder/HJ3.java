package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 华为机试：明明的随机数
 *
 * https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ3 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            int len = Integer.parseInt(in.nextLine());
            Set<Integer> sets = new HashSet<>(len);
            while (in.hasNextLine()) {
                sets.add(Integer.parseInt(in.nextLine()));
            }
            len = sets.size();

            // 用小顶堆实现的排序不太对
            /*
            Heap heap = new Heap(sets.size());
            Iterator<Integer> it = sets.iterator();
            while (it.hasNext()) {
                heap.insert(it.next());
            }
            heap.print();
             */

            // 用快排实现
            int i = 0;
            int[] arr = new int[len];
            Iterator<Integer> it = sets.iterator();
            while (it.hasNext()) {
                arr[i++] = it.next();
            }
            quickSort(arr, 0, len-1);
            for (int j = 0; j < len; j++) {
                System.out.println(arr[j]);
            }
         }

    }

    public static void main(String[] args) {
        Set<Integer> sets = new HashSet<>(11);
        sets.add(25);
        sets.add(19);
        sets.add(91);
        sets.add(32);
        sets.add(6);
        sets.add(86);
        sets.add(54);
        sets.add(103);
        sets.add(58);
        sets.add(45);
        sets.add(102);
        int len = sets.size();

        // 用小顶堆实现的排序不太对
            /*
            Heap heap = new Heap(sets.size());
            Iterator<Integer> it = sets.iterator();
            while (it.hasNext()) {
                heap.insert(it.next());
            }
            heap.print();
             */

        // 用快排实现
        int i = 0;
        int[] arr = new int[len];
        Iterator<Integer> it = sets.iterator();
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        quickSort(arr, 0, len);
        for (int j = 0; j < len; j++) {
            System.out.println(arr[j]);
        }
    }

    // 实现一个小顶堆，及插入操作
    public static class Heap {
        int[] a;  // 存储数据的数组，从下标 1 开始存储
        int n;  // 堆的容量，即最多可存储的元素数量
        int count;  // 堆中已经存储的元素量

        public Heap(int capacity) {
            a = new int[capacity+1];
            n = capacity;
            count = 0;
        }

        public boolean insert(int data) {
            if (count >= n) return false;
            count++;
            a[count] = data;  // 尾部插入
            // 自底向上堆化
            int i = count;
            while (i/2 > 0 && a[i] < a[i/2]) {
                swap(a, i/2, i);
                i = i/2;
            }
            return true;
        }

        public void print() {
            print1(a, 1);
        }

        private void print1(int[] a, int i) {
            if (i >= a.length || a[i] <= 0) return;

            System.out.println(a[i]);

            print1(a, 2 * i);
            print1(a, 2 * i + 1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition(a, lo, hi);
        quickSort(a, lo, p-1);
        quickSort(a, p+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi, base = a[lo];
        while (i < j) {
            while (base <= a[j] && i < j) {
                j--;
            }
            while (base >= a[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        a[lo] = a[i];
        a[i] = base;

        return i;
    }

}
