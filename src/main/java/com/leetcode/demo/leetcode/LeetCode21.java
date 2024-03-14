package com.leetcode.demo.leetcode;

import com.leetcode.demo.ListNode;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (null != list1 && null != list2) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (null != list1) {
            p.next = list1;
        }
        if (null != list2) {
            p.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}

class FalseCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata){
        return false;
    }
}
@Conditional(FalseCondition.class)
class ConditionTest {
    @Bean
    public void nowcoder() {
        System.out.println("nowcoder ");
    }
    @Bean
    public void spring() {
        System. out.println("spring");
    }
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ConditionTest.class);
    }
}
