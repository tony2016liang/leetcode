package com.leetcode.demo.leetcode;

import com.leetcode.demo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 */
public class LeetCode543 {
    // 二叉树的最大直径不一定经过根节点，所以需要计算全部节点的最大路径，然后比较最大
    // 至于某个节点的最大路径，则可以认为是这个节点的左右子树的最大深度的和
    public int diameterOfBinaryTree(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int diameter = maxDepth(node.left) + maxDepth(node.right);
            if (diameter > res) {
                res = diameter;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    // 计算最大深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        return Math.max(leftD, rightD) + 1;
    }
}
