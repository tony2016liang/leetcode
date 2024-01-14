package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class LeetCode160 {

    /**
     * 解法思路（来自labuladong）：
     *
     * 由于两条链表相交点之前的节点数不定，也没有什么确定的规律，所以无法通过双指针遍历的方式同时到达相交点。
     * 但是如果两个指针将两个链表都走一遍，则总的节点数就是相同的了。
     *
     * 所以具体的做法就是让两个指针都遍历两个链表，当遍历第二个链表的时候，再相遇，则相遇点就是两条链表的
     * 相交点。而且这种做法对于没有相交点的情况也适用，最后会返回null。
     *
     * 本解法的时间复杂度是 O(m+n)，m、n分别为两个链表的长度；空间复杂度是 O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;

            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
