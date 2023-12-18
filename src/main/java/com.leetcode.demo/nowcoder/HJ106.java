package com.leetcode.demo.nowcoder;
import java.util.*;

/**
 * 华为机试 HJ106
 * https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37&tqId=21329&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ106 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i=s.length(); i>=0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
