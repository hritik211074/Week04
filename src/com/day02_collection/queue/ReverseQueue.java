package com.day02_collection.queue;

import java.util.*;
public class ReverseQueue {

    static void findReverseQueue(Queue<Integer>qq){
        Stack<Integer> vq = new Stack<>();

        // Move all elements from queue to stack
        while (!qq.isEmpty()) {
            vq.push(qq.poll());
        }

        // Move all elements back from stack to queue
        while (!vq.isEmpty()) {
            qq.add(vq.pop());
        }
    }
    public static void main(String[] args) {

        // Create a scanner's object to read the user input
        Scanner sc=new Scanner(System.in);

        Queue<Integer>qq=new LinkedList<>();

        System.out.println("Enter the number of element :");
        int num=sc.nextInt();

        System.out.println("Enter the values: ");
        for(int i=0;i<num;i++) {
            qq.add(sc.nextInt());
        }

        System.out.println(qq);
        findReverseQueue(qq);

        System.out.println("Reverse queue is: "+qq);

    }
}
