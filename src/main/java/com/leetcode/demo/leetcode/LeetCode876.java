package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 链表的中间节点
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
