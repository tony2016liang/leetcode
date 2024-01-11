package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null && p1.next != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                return true;
        }
        return false;
    }

}
