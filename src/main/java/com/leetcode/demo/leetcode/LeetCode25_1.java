package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 合并k个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class LeetCode25_1 {

    /**
     * 来自官解1：
     *
     * 利用了 2 条有序链表合并的思路，这个解法的基本思路就是遍历 lists 中的所有
     * 子链表，然后两两合并，最终得到的就是包含了所有节点的一个大的链表。
     *
     * 复杂度：2条链条合并，时间复杂度是 O(k)，k是其中较短的链表的长度，空间复杂度是 O(1),
     *      那么对应到本题，n 次的双链表合并，时间复杂度是 O(k*k*n)，空间复杂度是 O(1)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode node : lists) {
            ans = mergeTwoLists(ans, node);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
