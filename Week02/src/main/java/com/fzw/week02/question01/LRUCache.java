package com.fzw.week02.question01;

import java.util.*;

/**
 * @author fzw
 * @description 146. LRU 缓存机制
 * @date 2021-06-30
 **/
public class LRUCache {
    private final Map<Integer, ListNode> cache;
    private final int capacity;
    private int count;
    private ListNode head;
    private ListNode tail;

    private static class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            ListNode listNode = this.cache.get(key);
            this.Remove(listNode);
            this.addFirst(listNode);
            return listNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            ListNode listNode = this.cache.get(key);
            listNode.value = value;
            this.cache.put(key, listNode);
            this.Remove(listNode);
            this.addFirst(listNode);
        } else {
            if (this.count == this.capacity) {
                ListNode last = this.removeLast();
                this.cache.remove(last.key);
                this.count = this.count - 1;
            }
            ListNode cur = new ListNode(key, value);
            this.addFirst(cur);
            this.cache.put(key, cur);
            this.count = this.count + 1;
        }
    }

    public ListNode removeLast() {
        ListNode pre = tail.pre;
        ListNode prepre = tail.pre.pre;
        prepre.next = tail;
        tail.pre = prepre;
        return pre;
    }

    public void addFirst(ListNode temp) {
        ListNode next = head.next;
        head.next = temp;
        temp.next = next;
        next.pre = temp;
        temp.pre = head;
    }

    public void Remove(ListNode node) {
        ListNode next = node.next;
        ListNode pre = node.pre;
        next.pre = pre;
        pre.next = next;
    }
}
