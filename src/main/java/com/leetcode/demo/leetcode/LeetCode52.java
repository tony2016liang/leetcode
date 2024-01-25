package com.leetcode.demo.leetcode;

/**
 * N 皇后 II
 * https://leetcode.cn/problems/n-queens-ii/description/
 */
public class LeetCode52 {
    int res = 0;
    public int totalNQueens(int n) {
        // 先初始化一个棋盘，所有格子都是空位（=0）
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        // 从第1行开始回溯
        backtrack(board, 0);
        return res;
    }

    private void backtrack(int[][] board, int row) {
        if (row == board.length) {
            res++;
            return;
        }
        // 从第1列开始遍历，判断每个格子是否可以放皇后
        for (int col = 0; col < board[0].length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            // 前序位置，做选择
            board[row][col] = 1;
            // 进入下一次决策
            backtrack(board, row + 1);
            // 后序位置，撤销选择
            board[row][col] = 0;
        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        // 需要从 同列、左上方、右上方 三个方向判断

        // 同列
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 1) {
                return false;
            }
        }

        // 左上方
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        // 右上方
        for (int r = row - 1, c = col + 1; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode52 leetCode52 = new LeetCode52();
        int res = leetCode52.totalNQueens(4);
        System.out.println();
    }
}
