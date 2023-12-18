package com.leetcode.demo.nowcoder;
import java.util.*;

/**
 * 华为机试HJ10: 字符个数统计
 * https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";
        if (in.hasNextLine())
            str = in.nextLine();
        Map<String, String> map = new HashMap<>(128);
        for (String s : str.split("")) {
            map.put(s, s);
        }
        System.out.println(map.size());
    }
}
