package com.leetcode.demo.nowcoder;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 华为机试 HJ20：密码验证合格程序
 * https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行
 */
public class HJ20 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String s = in.nextLine();
//            verify(s);
//        }
        String[] ss = {"021Abc9000\n", "021Abc9Abc1\n", "021ABC9000\n", "021$bc9000"};
        for (String s : ss) {
            verify(s);
        }
    }

    private static void verify(String s) {
        Pattern p1 = Pattern.compile("[a-z]+");  // 匹配小写字母
        Pattern p2 = Pattern.compile("[A-Z]+");  // 匹配大写字母
        Pattern p3 = Pattern.compile("\\d+");  // 匹配数字
        Pattern p4 = Pattern.compile("[^a-zA-Z\\d\\n]+");  //匹配除大小写字母、数字、换行符之外的所有特殊字符
        // 密码的位数不能低于8
        if (s.length() <= 8) {
            System.out.println("NG");
            //continue;
        }

        // 大写字母、小写字母、数字、特殊字符，必须包含其中的三者以上
        int count = 0;
        if (p1.matcher(s).find()) count++;
        if (p2.matcher(s).find()) count++;
        if (p3.matcher(s).find()) count++;
        if (p4.matcher(s).find()) count++;
        if (count < 3) {
            System.out.println("NG");
            //continue;
        }

        // FIXME 这个地方有点问题，根据题意，其实只要判断长度为3的子串是否有重复的就行：
        //  因为如果长度为3的有，虽然长度大于3的不一定有，但已没必要继续判断，直接返回NG即可；
        //  而如果长度为3的没有，那么长度大于3的也不可能有，二者是包含关系
        // 不能有长度大于2的包含公共元素的子串重复
        HashSet<String> sets = new HashSet<>();
        int i = 3;  // 位数，即待考察的子串的长度，从 3 位数开始，逐渐递增
        // 确认到 s.length()-1 长度的子串
        boolean valid = true;
        while (valid && i < s.length()) {
            for (int j = 0; j <= s.length() - i; j++) {
                String key = s.substring(j, j + i);
                if (sets.contains(key)) {
                    System.out.println("NG");
                    valid = false;
                    break;
                } else {
                    sets.add(key);
                }
            }
            i++;
        }

        // 最后三个点都验证没问题了，再输出 OK
        if (valid) {
            System.out.println("OK");
        }
    }
}
