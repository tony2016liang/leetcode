package com.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createByArray(Integer[] nums) {
        if (nums.length == 0 || nums[0] == null) {
            return null;
        }
        // 数组下标从1开始，则针对下标 n 的节点，其左子结点的下标为 2n，右子节点的下标为 2n+1
        // 数组下标从0开始，则相应的坐标节点要+1，即左子结点为 2n+1，右子节点为 2n+2
        /**
         * 1、子节点坐标：
         *    如果数组下标从1开始，则针对下标 n 的节点，其左子结点的下标为 2n，右子节点的下标为 2n+1；
         *    如果数组下标从0开始，则相应的坐标节点要+1，即左子结点为 2n+1，右子节点为 2n+2
         * 2、非叶子节点：
         *    针对一个要构建完全二叉树的数组，其最后一个非叶子节点的下标是 nums.length/2 - 1
         */
        int n = nums.length;
        List<TreeNode> nodes = new ArrayList<>(n);
        for (Integer i : nums) {
            if (null == i) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(i));
            }
        }
        // 处理所有非叶子节点，叶子节点不用处理
        for (int i = 0; i < n/2; i++) {
            // 处理空节点
            if (null == nodes.get(i)) {
                continue;
            }
            // 处理空的子节点，并且子节点下标不能超出数组界限（针对最后一个非叶子节点）
            TreeNode node = nodes.get(i);
            if ((2 * i + 1) < n && null != nodes.get(2 * i + 1)) {
                node.left = nodes.get(2 * i +1);
            }
            if ((2 * i + 2) < n && null != nodes.get(2 * i + 2)) {
                node.right = nodes.get(2 * i + 2);
            }
        }

        return nodes.get(0);
    }

    /**
     * n 层满二叉树的节点数是 2^n-1
     * n 层完全二叉树的节点数范围是 2^(n-1) ~ 2^n-1
     * 如果已知完全二叉树的节点数为 n，则该二叉树的层数或深度可以计算为： log<2>n 下取整 + 1
     *
     * @param nodeSum
     * @return
     */
    private static int getDepthofTree(int nodeSum) {
        if (nodeSum < 1) {
            return 0;
        }
        // 向下取整 + 1
        return (int)((Math.log(nodeSum)) / (Math.log(2))) + 1;
    }

    public static void main(String[] args) {
//        int depthofTree1 = getDepthofTree(1);
//        int depthofTree2 = getDepthofTree(2);
//        int depthofTree3 = getDepthofTree(3);
//        int depthofTree4 = getDepthofTree(4);
//        int depthofTree7 = getDepthofTree(7);
//        int depthofTree8 = getDepthofTree(8);
        double pow1 = Math.pow(2, 3);
        double pow2 = Math.pow(2, 4);
        double pow3 = Math.pow(2, 5);
        System.out.println();
    }
}
