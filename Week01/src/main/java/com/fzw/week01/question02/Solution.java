package com.fzw.week01.question02;

import com.fzw.week01.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author fzw
 * @description 21. 合并两个有序链表
 * @date 2021-06-29
 **/
public class Solution {


    @Test
    public void test() {
        ListNode node_4 = new ListNode(7, null);
        ListNode node_3 = new ListNode(5, node_4);
        ListNode node_2 = new ListNode(3, node_3);
        ListNode node_1 = new ListNode(1, node_2);

        ListNode node_14 = new ListNode(9, null);
        ListNode node_13 = new ListNode(8, node_14);
        ListNode node_12 = new ListNode(4, node_13);
        ListNode node_11 = new ListNode(2, node_12);

        ListNode result = this.mergeTwoLists(node_1, node_11);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }
        return head.next;
    }
}
