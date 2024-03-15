package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        // 思路：两两合并
        ListNode dummy = new ListNode(-1);
        for (ListNode listNode : lists) {
            ListNode p1 = listNode, p2 = dummy.next, p = dummy;
            while (null != p1 && null != p2) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }
            p.next = null == p1 ? p2 : p1;
        }
        return dummy.next;
    }

    // 另一种做法：优先级队列，或小根堆
    public ListNode mergeKLists1(ListNode[] lists) {
        // 维护一个优先级队列（PriorityQueue，即小根堆），将所有链表的头节点按顺序插入队列中
        Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode node : lists) {
            if (null == node) continue;
            queue.offer(node);
        }
        ListNode dummy = new ListNode(-1), tail = dummy;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode23 leetCode23 = new LeetCode23();
        int[][] nums1 = {{1,4,5},{1,3,4},{2,6}};
        // 输出：[1,1,2,3,4,4,5,6]
        ListNode[] nodes1 = ListNode.createNodes(nums1);
        ListNode listNode1 = leetCode23.mergeKLists1(nodes1);
        int[][] nums2 = {};
        // 输出：[]
        ListNode[] nodes2 = ListNode.createNodes(nums2);
        ListNode listNode2 = leetCode23.mergeKLists1(nodes2);
        int[][] nums3 = {{}};
        // 输出：[]
        ListNode[] nodes3 = ListNode.createNodes(nums3);
        ListNode listNode3 = leetCode23.mergeKLists1(nodes3);
        System.out.println();
    }
}
