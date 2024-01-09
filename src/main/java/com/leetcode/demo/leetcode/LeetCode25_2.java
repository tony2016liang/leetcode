package com.leetcode.demo.leetcode;

import javax.swing.tree.TreeNode;

/**
 * 合并k个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class LeetCode25_2 {

    /**
     * 来自官解2（分治法）：
     *
     * 这个方法的底层依然是双链表合并的思路。
     * 但在这个思路之上，不同于之前朴素的算法的从头遍历，从前往后进行两两合并，而是采取分治的思路，
     * 用递归的方式先合并相邻的两个链表，然后往上递归再合并相邻的两个链表，如此一直进行下去，直到
     * 得到最终的一条链表。
     *
     * 复杂度：
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l + ((r -l) >> 1);
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            val = val;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
