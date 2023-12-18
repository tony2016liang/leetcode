package com.leetcode.demo.nowcoder;
import java.util.*;
import java.util.stream.Stream;

/**
 * 华为机试 HJ23 删除字符串中出现次数最少的字符
 * https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            map.merge(c, 1, Integer::sum);
        }
        int min = Collections.min(map.values());
        for (char c : cs) {
            if (map.get(c) > min) {
                System.out.print(c);
            }
        }

    }
}
