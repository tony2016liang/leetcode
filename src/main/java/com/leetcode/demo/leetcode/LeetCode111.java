package com.leetcode.demo.leetcode;

import com.leetcode.demo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (null == node.left && null == node.right) {
                    return depth;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return depth;
    }

    /**
     * 测试用例：
     * 1、[3,9,20,null,null,15,7]，预期返回 2
     * 2、[2,null,3,null,4,null,5,null,6]，预期返回 5
     * 3、[1,2,3,4,5]，预期返回 2
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode111 leetCode111 = new LeetCode111();
        Integer[] nums = {2,null,3,null,4,null,5,null,6};
        TreeNode treeNode = TreeNode.createByArray(nums);
        int i = leetCode111.minDepth(treeNode);
        System.out.println();
    }
}
