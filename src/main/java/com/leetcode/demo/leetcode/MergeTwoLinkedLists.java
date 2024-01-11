package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 合并两个有序链表
 * （这是很多链表合并类算法的基础）
 */
public class MergeTwoLinkedLists {

    /**
     * 基本思路（要求时间复杂度 O(N)，空间复杂度 O(1)）：
     *
     * 定义一个空节点 head 用来接收和返回新的链表；
     * 一个 tail 节点用来表示待插入的节点的上一个节点（即新节点是插在 tail 后面的）；
     * 另外用指针 aPtr 和 bPtr 分别代表 a、b 两个链表中尚未插入的节点。
     *
     * 之后就是比较 aPtr 和 bPtr，将其中较小的节点插入 tail 后面（然后要移动 tail 指针位置），
     * 如果 aPtr 为空，则将 bPtr 整个链表插入 tail 后；反之 bPtr 为空，则插入 aPtr 剩余节点。
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
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
        // 将某个链表剩余的部分全部插入 tail
        tail.next = (aPtr == null ? bPtr : aPtr);
        return head.next;
    }

}
