package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题
 * https://leetcode.cn/problems/n-queens/description/
 */
public class LeetCode51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化一个二维数组，表示棋盘上的格子
        String[][] grids = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grids[i][j] = ".";
            }
        }
        // 记录已选择
        List<String> track = new ArrayList<>();
        return null;
    }
}
