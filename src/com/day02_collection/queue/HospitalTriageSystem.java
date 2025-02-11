package com.day02_collection.queue;


import java.util.*;
class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
public class HospitalTriageSystem {

    public static void main(String[] args) {

        // Create the scanner object to read user input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of patient: ");
        int num = sc.nextInt(); // Store the user input

        List<Pair<String,Integer>>list=new ArrayList<>();
        for(int i=0;i<num;i++){
            String name=sc.next();
            int severity=sc.nextInt();
            list.add(new Pair<>(name,severity));
        }
        Queue<Pair<Integer, String>> q = new PriorityQueue<>(
                (a, b) -> b.getKey().compareTo(a.getKey()) // Descending order of severity
        );

        for(Pair<String,Integer>pp:list){
           q.add(new Pair<>(pp.getValue(),pp.getKey()));
        }

        //  Display the result
        System.out.println("Order of patient treatment is: ");
        while (!q.isEmpty()) { // Always use poll() for PriorityQueue
            System.out.print(q.poll().getValue() + " ");
        }
    }
}
