package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * LeetCode 剑指offer 32 -II：
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class LeetCodeOffer32 {

    public static void print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();  // 存放节点的val，每层存放一个子数组
        Queue<TreeNode> queue = new LinkedList<>();
        if (null != root) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                tmp.add(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        print(root);
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }
}
