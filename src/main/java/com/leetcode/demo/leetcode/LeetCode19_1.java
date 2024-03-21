package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 删除链表的倒数第 N 个节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */
public class LeetCode19_1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 先用双指针找到倒数第 n 个节点
        ListNode p1 = head, p2 = head, pre = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }
        // 此时的 p2 已经是倒数第 n 个节点
        if (pre == p2) {
            // 此时说明要删除的就是当前节点
            return pre.next;
        } else {
            pre.next = p2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode19_1 leetCode191 = new LeetCode19_1();
        int[] head1 = {1,2,3,4,5};
        int n1 = 2;
        // 输出：[1,2,3,5]
        ListNode res1 = leetCode191.removeNthFromEnd(ListNode.create(head1), n1);

        int[] head2 = {1};
        int n2 = 1;
        // 输出：[]
        ListNode res2 = leetCode191.removeNthFromEnd(ListNode.create(head2), n2);

        int[] head3 = {1,2};
        int n3 = 1;
        // 输出：[1]
        ListNode res3 = leetCode191.removeNthFromEnd(ListNode.create(head3), n3);

        System.out.println();
    }
}
