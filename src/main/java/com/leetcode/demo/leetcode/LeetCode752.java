package com.leetcode.demo.leetcode;

import java.util.*;

/**
 * 打开转盘锁
 * https://leetcode.cn/problems/open-the-lock/description/
 */
public class LeetCode752 {

    /**
     * 思路：
     *   将转盘看成一个四个元素的数组，则按方向分，每个元素可以行走的路径有2条，正着走和反着走，因此所有的路径是8条；
     *   当目标值小于等于5时，正着走即可；当目标值大于5时，则反着走路径才会更短；
     *   所以策略就是根据4个目标值分别判断转盘应该走哪个方向，从而得到最短路径；
     *   然后这中间需要避开死亡节点
     *
     * 示例1：
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        // 记录已转过的记录，防止走回头路
        Set<String> visited = new HashSet<>();
        // 走过的步数
        int step = 0;
        // 初始状态，即出发点
        String start = "0000";
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (deads.contains(s)) {
                    continue;
                }
                if (s.equals(target)) {
                    return step;
                }
                // 遍历下一步的8个方向，添加到队列中
                for (int j = 0; j < 4; j++) {
                    String po = plusOne(s, j);
                    if (!visited.contains(po)) {
                        queue.offer(po);
                        visited.add(po);
                    }
                    String mo = minusOne(s, j);
                    if (!visited.contains(mo)) {
                        queue.offer(mo);
                        visited.add(mo);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 转盘锁的第 index 个元素正向转 1 步后得到的结果
    private String plusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    // 转盘锁的第 index 个元素反向转 1 步后得到的结果
    private String minusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        LeetCode752 leetCode752 = new LeetCode752();
        String[] deadends1 = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        int step1 = leetCode752.openLock(deadends1, target1);
        String[] deadends2 = {"8888"};
        String target2 = "0009";
        int step2 = leetCode752.openLock(deadends2, target2);
        String[] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        int step3 = leetCode752.openLock(deadends3, target3);
        System.out.println();
    }
}
