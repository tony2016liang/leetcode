package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;

/**
 * 寻找环形链表的入环起始节点
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class LeetCode142 {

    /**
     * 解法来自labuladong，思路如下：
     *
     * 在有环的情况下，假设快慢指针相遇时慢指针走了 k 步，则快指针走了 2k 步，而这多出来的 k 步一定都是在环上的，
     * 通过作图比较容易看出来，k 就是环长度的整数倍。
     * 此时再假设入环点（即尾节点的next节点）到两个指针的相遇点的距离是 m，则头节点到入环点的距离是 k-m，
     * 而此时快指针继续往前走，一直走到入环点的距离也是 k-m（作图的话更容易看出）。
     *
     * 根据以上思路，具体做法就是当快慢指针第一次相遇之后，把慢指针拨回到头节点，然后让这两个指针再次同时出发，这次
     * 二者每次前进的步数也都是 1，则当二者再次相遇时，相遇的点即为入环点
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        // 先判断有没有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        // 已知有环的情况下
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        ListNode head = ListNode.createWithCycle(nums, 1);
        ListNode res = detectCycle(head);
        System.out.println();
    }
}
