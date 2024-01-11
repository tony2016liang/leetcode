package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并k个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class LeetCode25_3 {

    /**
     * 基本思路：
     *
     * 这个解法的思路和我一开始的思路有点像，就是每次都把 k 个链表的 head 放到一起比较，
     * 取出最小的添加到新链表的尾部。
     * 不过我当时是把 k 个 head 都放到一个数组里面，然后自己判断最小，以及是不是null等，比较麻烦，
     * 耗时也比较大。
     * 这次的解法是用优先级队列 PriorityQueue 代替了数组，实现起来很方便，耗时也省了很多。
     *
     * （优先级队列 PriorityQueue 是 Java 实现的一个堆数据结构）
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode p = res;
        // 构造一个小顶堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));
        // 先预加载 k 个链表的头节点
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            // 弹出顶部的最小节点
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return res.next;
    }

}
