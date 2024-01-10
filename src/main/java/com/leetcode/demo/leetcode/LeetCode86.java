package com.leetcode.demo.leetcode;

/**
 * 分隔链表
 * https://leetcode.cn/problems/partition-list/description/
 */
public class LeetCode86 {

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode insertPtr = head; // 找寻插入位置的指针
        ListNode insertPre = new ListNode(-1);
        ListNode dummy = insertPre;
        insertPre.next = insertPtr;
        while (insertPtr != null && insertPtr.val < x) {
            insertPre = insertPtr;
            insertPtr = insertPtr.next;
        }
        ListNode mutualPtr = insertPtr; // 向后遍历查询需前移的节点的指针
        ListNode mutualPre = insertPre;
        while (mutualPtr != null) {
            if (mutualPtr.val < x) {
                // 摘出 mutualPtr
                mutualPre.next = mutualPtr.next;
                // 将 mutualPtr 接到前面去
                mutualPtr.next = insertPtr;
                insertPre.next = mutualPtr;
                // 更新 insertPre
                insertPre = insertPre.next;
                // 更新 mutualPtr
                mutualPtr = mutualPre.next;
            } else {
                mutualPre = mutualPtr;
                mutualPtr = mutualPtr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = ListNode.create(nums);
        ListNode res = partition(head, 3);
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static ListNode create(int[] nums) {
            if (nums.length < 1) return null;
            ListNode head = new ListNode(nums[0]);
            ListNode tail = head;
            for (int i = 1; i < nums.length; i++) {
                tail.next = new ListNode(nums[i]);
                tail = tail.next;
            }
            return head;
        }
    }
}
