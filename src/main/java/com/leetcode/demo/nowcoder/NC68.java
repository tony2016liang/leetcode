package com.leetcode.demo.nowcoder;

/**
 * 牛客网算法题NC68：跳台阶
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=188&&tqId=37379&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC68 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param number int整型
     * @return int整型
     */
    public int jumpFloor (int number) {
        // write code here
        if (number == 1) return 1;
        if (number == 2) return 2;

        return jumpFloor(number-1) + jumpFloor(number-2);
    }
}
