package com.leetcode.demo.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 剑指offer 32 -III：
 * 和 剑指offer 32 -II 类似，要求从上到下按层打印二叉树，
 * 但是打印顺序不同，要求之字形打印，即第一行按照从左到右，第二行按照从右到左。
 *
 * 实现方法可以和上一题一样，后面打印时对奇偶行不同处理即可，这种方法相较上一题变化不大；
 * 也可以构建二维数组时即按照打印的顺序依次插入，这种方式相较上题变化较大，这里采用的是这种方式
 */
public class LeetCodeOffer32III {

    public static void print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();  // 存放节点的val，每层存放一个子数组
        LinkedList<TreeNode> queue = new LinkedList<>();
        int line = 0;
        if (null != root) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node;
                // line 为偶数，表示奇数行，因为 line 是从 0 开始的
                if (line % 2 == 0) {
                    // 从头部开始移除元素
                    node = queue.remove();
                    tmp.add(node.val);
                    if (null != node.left) {
                        queue.add(node.left);
                    }
                    if (null != node.right) {
                        queue.add(node.right);
                    }
                } else {
                    // 从尾部开始移除元素，从而达到和上一行逆向的效果
                    node = queue.removeLast();
                    tmp.add(node.val);
                    // 为了继续达到顺插的效果，这里需要从右到左，然后依次插入队列头部
                    if (null != node.right) {
                        queue.addFirst(node.right);
                    }
                    if (null != node.left) {
                        queue.addFirst(node.left);
                    }
                }
            }
            res.add(tmp);
            line++;
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
        root.left.left.left = new TreeNode(8); // 4->8
        root.left.left.right = new TreeNode(9); // 4->9
        root.left.right.left = new TreeNode(10); // 5->10
        root.left.right.right = new TreeNode(11); // 5->11
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
