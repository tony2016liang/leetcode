package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 删除链表的倒数第 n 个节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */
public class LeetCode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        // 先让 p1 指针走 n 步
        for (int i = 0; i < n; i++) {
            if (p1 != null) {
                p1 = p1.next;
            }
        }
        ListNode p2 = head;
        ListNode pre2 = head;
        // p2 指针从头开始，和 p1 同时往后走
        // 由于 p1 领先 p2 指针 n 步，当 p1 走完整个链表，则 p2 也就到了链表倒数的第 n 个节点
        while (p1 != null) {
            p1 = p1.next;
            pre2 = p2;
            p2 = p2.next;
        }
        // 删除 p2 节点
        if (pre2 == p2) {
            // 当 pre2 == p2 时，说明要删除的就是当前节点，应该也就是头节点
            return pre2.next;
        } else {
            pre2.next = p2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        ListNode head = ListNode.create(nums);
        ListNode res = removeNthFromEnd(head, 1);
        System.out.println();
    }
}
