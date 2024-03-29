package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class LeetCode160_1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 思路就是将 headB 拼接到 headA 的尾部，然后找环的入环节点
        if (headA == null || headB == null) return null;

        // 拼接两条链表
        ListNode p = headA, tail = p, q = headB;
        while (p !=  null) {
            tail = p;
            p = p.next;
        }
        // 将 headB 挂到 headA 的尾部
        tail.next = q;

        // 查找最新的链表有没有环
        ListNode fast = headA, slow = headA;
        boolean hasCircle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCircle = true;
                break;
            }
        }
        if (!hasCircle) {
            // 返回前需要将两条链断开，否则会报错 ERROR: linked structure was modified.
            tail.next = null;
            return null;
        }

        // 找入环点，即为两条链表的相交点
        fast = headA;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        // 返回前需要将两条链断开，否则会报错 ERROR: linked structure was modified.
        tail.next = null;

        return fast;
    }
}
