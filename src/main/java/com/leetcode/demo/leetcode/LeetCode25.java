package com.leetcode.demo.leetcode;

/**
 * 合并k个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class LeetCode25 {

    /**
     * 基本思路：
     * 用一个长度为 n 的一维数组 heads 接收 lists 中所有链表的头结点，
     * 从 heads 中查找最小的节点插入待返回的链表 res 尾部，这个被用掉的
     * 最小节点之后再用其 next 节点替换掉。如此循环，直到 lists 中所有
     * 子链表都为空。
     *
     * 时间复杂度：由于每获取一个最小节点，都要遍历2遍heads，判空和找最小，假设子链表的平均
     *      长度为 k，heads 大小为 n，则时间复杂度为 O(k*n*n);
     * 空间复杂度：由于返回的链表节点都是重新 new 出来的，所以空间复杂度是 O(k*n)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ListNode node = res;
        if (allNull(lists)) return res;

        int len = lists.length;
        ListNode[] heads = new ListNode[len];
        for (int i = 0; i < len; i++) {
            if (lists[i] != null) heads[i] = lists[i];
        }

        // 跳出条件是所有的链表都遍历完
        while (!allNull(heads)) {
            // 找到 heads 中值最小的链表节点的下标
            int minIndex = getMinListNode(heads);
            // 将这个值取出，串到待返回的链表 res 上
            node.next = new ListNode(heads[minIndex].val);
            node = node.next;
            // heads 中这个已被取用的节点需要被其下个节点替换
            heads[minIndex] = heads[minIndex].next;
        }

        return res.next;
    }

    private int getMinListNode(ListNode[] heads) {
        int index = -1;
        for (int i = 0; i < heads.length; i++) {
            if (heads[i] != null) {
                if (index == -1) {
                    index = i;
                } else if (heads[i].val < heads[index].val) {
                    index = i;
                }
            }
        }
        return index;
    }

    private boolean allNull(ListNode[] lists) {
        if (lists == null) return true;
        for (ListNode node : lists) {
            if (node != null) return false;
        }
        return true;
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
