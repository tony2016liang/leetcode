package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * BM1 反转链表
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM1 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode ReverseList (ListNode head) {
        // write code here
        return reverseListByStack(head);
    }

    // 用栈解决
    private static ListNode reverseListByStack (ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (null != head) {
            stack.push(head.val);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode newHead = new ListNode(stack.pop());
        ListNode tail = newHead;
        while (!stack.isEmpty()) {
            ListNode tmp = new ListNode(stack.pop());
            if (null == newHead) {
                newHead = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        tail.next = null;  // 最后的tail是原先的头节点，这里为了避免成环状，需要设置tail的next为null
        return newHead;
    }

    // 双链表
    private static ListNode reverseListByBiList (ListNode head) {
        ListNode newHead = null;
        while (null != head) {
            // 先取出下一节点备用
            // 这个节点会成为下次循环的头节点
            ListNode tmp = head.next;
            // 原链表的头节点挂到了新链表上
            head.next = newHead;
            // 将新链表头结点指向迁移过来的原链表头结点
            newHead = head;
            // 更新头节点
            head = tmp;
        }
        return newHead;
    }

    // 递归的方法
    private static ListNode reverseListByRecurrent (ListNode head) {
        // 结束条件
        if (null == head || null == head.next) {
            return head;
        }
        ListNode next = head.next;  // 先摘出head的next节点备用
        ListNode reverse = reverseListByRecurrent(next);
        // reverse 是反转之后的链表，所以反转之后 next 应该是原链表的尾节点
        // 将 next 的下一个节点指向 head，就完成了反转
        next.next = head;
        // 反转后 head 作为新链表的尾节点，为了避免出现回环，需要将 next 置空
        head.next = null;
        return reverse;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newH = ReverseList(head);
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
