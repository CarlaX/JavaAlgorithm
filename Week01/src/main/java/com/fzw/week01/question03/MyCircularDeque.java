package com.fzw.week01.question03;

/**
 * @author fzw
 * @description 641. 设计循环双端队列
 * @date 2021-06-29
 **/
public class MyCircularDeque {
    private int[] arr;
    private int head;
    private int tail;
    private int length;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        arr = new int[k + 1];
        head = 0;
        tail = 0;
        length = k + 1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        arr[head] = value;
        head = (head + 1) % length;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        tail = (tail - 1 + length) % length;
        arr[tail] = value;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        head = (head - 1 + length) % length;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        tail = (tail + 1) % length;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return arr[(head - 1 + length) % length];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return arr[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (tail == head) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if ((head + 1) % length == tail) {
            return true;
        } else {
            return false;
        }
    }
}
