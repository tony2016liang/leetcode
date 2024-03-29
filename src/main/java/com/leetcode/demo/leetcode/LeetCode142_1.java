package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class LeetCode142_1 {

    // 寻找链表的入环点
    public ListNode detectCycle(ListNode head) {
        // 先找第一次的相遇点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 找到相遇点后，将任意一个指针指向 head，然后同时单步前进
        // 则其再次相遇的点就是环的起始点（相关原理在此不赘述，可以自行查询）
        fast = head;
        if (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
