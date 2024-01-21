package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 华为机试 HJ68 成绩排序
 * https://www.nowcoder.com/practice/8e400fd9905747e4acc2aeed7240978b?tpId=37&tqId=21291&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ68 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());  // 学生个数
        int ord = Integer.parseInt(in.nextLine());  // 排序（0-从高到低，1-从低到高）
        ArrayList<Score> list = new ArrayList<>(n);
        while (in.hasNext()) {
            String[] ss = in.nextLine().split(" ");
            list.add(new Score(ss[0], Integer.parseInt(ss[1])));
        }
        list.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return ord > 0 ? (o1.score - o2.score) : (o2.score - o1.score);
            }
        });
        list.forEach(s -> {
            System.out.println(s.name + " " + s.score);
        });
    }

    static class Score {
        String name;
        int score;

        public Score (String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
