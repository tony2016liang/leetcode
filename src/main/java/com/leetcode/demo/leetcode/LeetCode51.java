package com.leetcode.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题
 * https://leetcode.cn/problems/n-queens/description/
 */
public class LeetCode51 {

    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        // 初始化一个棋盘，棋盘的所有位置都是空位， "." 表示空位， "Q" 表示有皇后占据
        List<String> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    // row 表示待放置的行数（从0开始）
    private static void backtrack(List<String> board, int row) {
        // row 等于 n，表示棋盘放满，一种方案已经完成
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    /**
     * 判断某个格子是否可以继续放置皇后
     *
     * 由于放皇后的顺序是从上到下、从前往后进行的，而判断一个格子是否可以继续放置皇后，
     * 跟后面的格子无关，只要看前面处理过的格子中是否有冲突的即可，所以只需要判断格子
     * 的同列、左上方以及右上方是否有会影响到其摆放的皇后即可
     *
     * @param board 棋盘
     * @param row 待判断的格子的行
     * @param col 待判断的格子的列
     * @return
     */
    private static boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        // 判断同列
        for (int r = 0; r < row; r++) {
            if (board.get(r).charAt(col) == 'Q') {
                return false;
            }
        }

        // 判断左上方
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
        }

        // 判断右上方
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println();
    }

}
