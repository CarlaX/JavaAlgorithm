package com.fzw.week02.question05;

import com.fzw.week02.common.ListNode;

/**
 * @author fzw
 * @description 23. 合并K个升序链表
 * @date 2021-06-30
 **/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        int newLength = 0;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        if (length % 2 == 0) {
            newLength = length / 2;
        } else {
            newLength = length / 2 + 1;
        }
        ListNode[] newListNodes = new ListNode[newLength];

        for (int i = 0; i < length; i = i + 2) {
            if (i == length - 1) {
                newListNodes[i / 2] = lists[i];
            } else {
                newListNodes[i / 2] = this.mergeNode(lists[i], lists[i + 1]);
            }
        }
        return this.mergeKLists(newListNodes);
    }


    public ListNode mergeNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

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
