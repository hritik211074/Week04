package com.day02_collection.queue_inteface;

import java.util.*;

class StackUsingQueues {
    // Two queues to implement stack behavior
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (O(1))
    public void push(int x) {
        q1.add(x); // Add the element to q1
    }

    // Pop operation (O(N))
    public int pop() {
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int top = q1.poll(); // Get the last element (top of stack)

        // Swap q1 and q2, so q1 becomes the main queue again
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top; // Return the popped element
    }

    // Top operation (O(N)) - Similar to pop, but keeps the last element
    public int top() {
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int top = q1.peek(); // Peek the last element (top of stack)

        q2.add(q1.poll()); // Move last element to q2 as well

        // Swap q1 and q2, so q1 becomes the main queue again
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top; // Return the top element without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Pushing elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Popping top element (should be 3)
        System.out.println(stack.pop()); // Output: 3
    }
}
