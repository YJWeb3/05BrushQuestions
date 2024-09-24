package com.wclass.structalgorithm.sort_05.leetcode_nowcoder.d23_d22_impl_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: StructAlgorithm
 * @ClassName QueueS5D23
 * @description:
 * @author: W哥
 * @create: 2024-09-24-22-21
 * @Version 1.0
 **/
public class QueueS5D23 {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public QueueS5D23() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
