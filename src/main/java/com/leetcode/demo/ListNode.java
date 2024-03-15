package com.leetcode.demo;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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

    public static ListNode[] createNodes(int[][] numss) {
        ListNode[] nodes = new ListNode[numss.length];
        int i = 0;
        for (int[] nums : numss) {
            if (nums.length < 1) continue;
            nodes[i++] = create(nums);
        }
        return nodes;
    }

    /**
     * 构建带一个环的单链表
     *
     * @param nums 构建所使用的数组元素
     * @param pos 链表尾连接到链表中的位置（入环点，索引从 0 开始）
     * @return
     */
    public static ListNode createWithCycle(int[] nums, int pos) {
        if (nums.length < 1) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        // 初始化入环节点，如果 pos == 0，则 head 就是入环节点
        ListNode pNode = (pos == 0 ? head : null);
        for (int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
            if (i == pos) {
                // 此时的 tail 就是当前节点
                pNode = tail;
            }
        }
        tail.next = pNode;
        return head;
    }
}
