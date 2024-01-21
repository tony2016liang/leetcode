package com.leetcode.demo.nowcoder;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 华为机试 HJ17：坐标移动
 * https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tqId=21240&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(";");
        // 匹配：A|D|W|S 其中之一开头，接着是一位非零整数，接着可以没有，也可以是一位含0的整数
        Pattern p = Pattern.compile("^[WASD][1-9][0-9]{0,1}$");
        int[] loc = {0, 0};
        for (String s : ss) {
            if (p.matcher(s).find()) {
                String direction = s.substring(0, 1);
                int distense = Integer.parseInt(s.substring(1));
                switch (direction) {
                    case "A":  // 左移
                        loc[0] = loc[0] - distense;
                        break;
                    case "D":  // 右移
                        loc[0] = loc[0] + distense;
                        break;
                    case "W":  // 上移
                        loc[1] = loc[1] + distense;
                        break;
                    case "S":  // 下移
                        loc[1] = loc[1] - distense;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(loc[0] + "," + loc[1]);
    }
}
