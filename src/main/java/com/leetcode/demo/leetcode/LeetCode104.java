package com.leetcode.demo.leetcode;


import com.leetcode.demo.TreeNode;

/**
 * 二叉树最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
public class LeetCode104 {
    // 方法一：
    // 左右子树递归的解法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    // 方法二：
    // 借助二叉树前中后序遍历的规律，使用全局变量记录最大深度
    int maxDepth = 0;
    int curDepth = 0;  // 记录当前节点的深度
    public int maxDepth1(TreeNode root) {
        traverse(root, curDepth);
        return maxDepth;
    }

    private void traverse(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        // 前序位置，每次 curDepth 都加一
        curDepth++;
        if (curDepth > maxDepth) {
            maxDepth = curDepth;
        }
        traverse(root.left, curDepth);
        traverse(root.right, curDepth);
        // 后序的位置，还需要把 curDepth 的值都减回去
        curDepth--;
    }
}
