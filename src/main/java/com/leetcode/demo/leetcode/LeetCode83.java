package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class LeetCode83 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        ListNode head = ListNode.create(nums);
        ListNode res = deleteDuplicates(head);
        System.out.println();
    }
}
