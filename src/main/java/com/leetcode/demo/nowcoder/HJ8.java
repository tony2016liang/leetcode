package com.leetcode.demo.nowcoder;
import java.util.*;
import java.util.stream.Stream;

/**
 * 华为机试 HJ8 合并表记录
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>(n);
        int i = n;
        while (i > 0) {
            String[] tmp = in.nextLine().split(" ");
            int k = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            map.merge(k, v, Integer::sum);
            i--;
        }
        List list = new ArrayList(map.keySet());
        Collections.sort(list, Comparator.naturalOrder());
        for (i=0; i<list.size(); i++) {
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }

    }
}
