package com.leetcode.demo.nowcoder;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 华为机试 HJ101
 * https://www.nowcoder.com/practice/dd0c6b26c9e541f5b935047ff4156309?tpId=37&tqId=21324&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ101 {

    private static FileOutputStream fop;
    public static void main(String[] args) throws Exception {
        fop = new FileOutputStream(new File("/Users/tonyliang/IdeaProjects/leetcode/log/out.txt"));
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String s = in.nextLine();
//        int b = in.nextInt();
        int n = 161;
        String s = "17882 89549 45713 20643 28397 52496 82915 24380 96621 96575 15810 4294 70607 89390 5688 22984 73204 19272 4834 62690 77131 28498 54856 26085 25421 45112 62859 24148 18733 52906 86305 92228 19525 43115 13342 57652 41702 1981 75020 41167 31276 730 60964 65415 57779 72271 64724 21004 32222 88770 77940 49512 24914 41266 10412 80519 59527 23420 58991 13947 74108 6164 69703 964 31218 4224 16511 36920 31972 92541 53267 24067 79480 7611 85190 61201 47781 19475 30214 61078 56647 57210 5403 4466 88838 72869 80498 17583 18771 78488 13977 12928 95729 59056 8996 33131 84228 54875 61015 11115 4757 45801 19097 17854 6917 84923 17331 42507 33807 74839 5160 19833 3227 91507 15414 81654 1904 62729 76872 21684 76930 3440 60958 52484 81793 23546 50444 44896 33589 48253 23928 4484 51298 44823 20062 38643 88783 89414 36696 3605 37886 89816 24617 80665 34377 55715 77323 19591 51037 60077 28190 91582 36263 4602 14581 92872 43369 68260 56710 12277 65331";
        int b = 0;
        long start = System.currentTimeMillis();
        String[] ss = s.split(" ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        quickSort(arr, 0, n-1);
//        insertSort(arr);
        if (b > 0) {
            for (int i=n-1; i>=0; i--) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i=0; i<n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    // fixme quickSort排序问题，执行上面161个元素的用例时，执行很久都不能结束，重复执行了很多，还没排查出原因
    public static void quickSort(int[] arr, int lo, int hi) throws Exception {
        if (lo >= hi) return;

        int p = partition(arr, lo, hi);
        if (fop != null) {
            String s = p + "\n";
            fop.write(s.getBytes());
        }
        quickSort(arr, 0, p-1);
        quickSort(arr, p+1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi, base = arr[lo], t;
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

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j-1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }
    }
}
