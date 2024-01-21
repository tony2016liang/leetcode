package com.leetcode.demo.nowcoder;
import java.util.*;

/**
 * 华为机试 HJ33 整数与IP地址间的转换
 * https://www.nowcoder.com/practice/66ca0e28f90c42a196afd78cc9c496ea?tpId=37&tqId=21256&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ33 {

    public static void main(String[] args) {
//        System.out.println("10.0.3.193".contains("."));
        System.out.println(ipToLong("39.66.68.72"));
        System.out.println(longToIP(Long.parseLong("3868643487")));
        System.out.println(convert("39.66.68.72"));
        System.out.println(convert("3868643487"));
        System.out.println(con("39.66.68.72"));
        System.out.println(con("3868643487"));
        System.out.println();
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.contains(".")) {
                System.out.println(ipToLong(s));
            } else {
                System.out.println(longToIP(Long.parseLong(s)));
            }
        }
    }

    private static long ipToLong(String ip) {
        String[] ips = ip.split("\\.");
        String longBi = "";
        for (int i = 0; i < ips.length; i++) {
            longBi = longBi + get8BitStrOfInt(Integer.parseInt(ips[i]));
        }
        return biStrToLong(longBi);
    }
    // 获取8位bit的字符串（适用于255以下的整数）
    private static String get8BitStrOfInt(int n) {
        String bs = Integer.toBinaryString(n);
        while (bs.length() < 8) {
            bs = "0" + bs;
        }
        return bs;
    }
    private static long biStrToLong(String bi) {
        long res = 0;
        for (int i = 0; i < bi.length(); i++) {
            int t = Integer.parseInt(bi.substring(bi.length()-i-1, bi.length()-i));
            res += t * Math.pow(2, i);
        }
        return res;
    }

    private static String longToIP(long n) {
        String bi = Long.toBinaryString(n);
        while (bi.length() < 32) {
            bi = "0" + bi;
        }
        String[] ips = new String[4];
        for (int i = 0, j = 0; i < bi.length(); i+=8, j++) {
            ips[j] = String.valueOf(biStrToLong(bi.substring(i, i+8)));
        }
        return String.join(".", ips);
    }

    // 题解里看到的一个牛逼的解法
    public static String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < 4; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < 4; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static String con(String s) {
        if (s.contains(".")) {
            // ipv4 -> long
            String[] ss = s.split("\\.");
            long res = 0;
            for (int i=0; i<4; i++) {
                res = res * 256 + Long.parseLong(ss[i]);
            }
            return "" + res;
        } else {
            // long -> ipv4
            String res = "";
            long sl = Long.parseLong(s);
            for (int i=0; i<4; i++) {
                res = sl % 256 + "." + res;
                sl /= 256;
            }
            return res.substring(0, res.length()-1);
        }
    }
}
