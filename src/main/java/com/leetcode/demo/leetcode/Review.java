package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;
import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

public class Review {

    // 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (null != cur) {
            if (cur.val >= x) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 当 head == null 或 整个链表都是小于 x 的，得到的 cur == null
        if (null == cur) {
            return head;
        }
        ListNode p1 = pre, p2 = cur;
        while (null != p2) {
            if (p2.val < x) {
                p1.next = p2.next;  // 取出待移动的节点 p2
                p2.next = cur;
                pre.next = p2;  // 将取出的节点 p2 链接到前半部分 pre 和 cur 节点之间
                pre = pre.next;  // 由于插入点在 cur 之前，所以 cur 是不用动的，pre 每次后移一位
                p2 = p1.next;  // 由于取出的节点在 p1 后，所以 p1 也不用动，每次取出 p2 后，将后面的节点再赋值给 p2
                continue;
            }
            // 如果不满足移动的条件，指针正常后移即可
            if (null == p2) break;
            p1 = p2;
            p2 = p2.next;
        }
        // head 有可能会变，dummy 是不会变的，所以不能直接返回 head
        return dummy.next;
    }

    // 另一种做法
    public ListNode partition1(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode bigDummy = new ListNode(-1);
        ListNode small = smallDummy, big = bigDummy;
        while (null != head) {
            if (head.val >= x) {
                big.next = head;
                big = big.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        big.next = null;  // 这个步骤比较重要，避免最后的结果出现环
        small.next = bigDummy.next;
        return smallDummy.next;
    }



    public static void main(String[] args) {
        Review review = new Review();
        int[] num1 = {1,4,3,2,5,2};
        ListNode head1 = ListNode.create(num1);
        int x1 = 3;
        ListNode partition1 = review.partition1(head1, x1);
        int[] num2 = {2,1};
        ListNode head2 = ListNode.create(num2);
        int x2 = 2;
        ListNode partition2 = review.partition1(head2, x2);
        int[] num3 = {1,4,3,0,2,5,2};
        ListNode head3 = ListNode.create(num3);
        int x3 = 3;
        ListNode partition3 = review.partition1(head3, x3);
        System.out.println();
    }
}


