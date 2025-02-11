package com.day02_collection.queue_inteface;

class CircularBuffer {
    private int[] buffer;
    private int head = 0, tail = 0, size = 0, capacity;

    // Constructor to initialize the buffer
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert element into the buffer (overwrites oldest if full)
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        // Increase size if not full
        if (size < capacity) size++;
        else head = (head + 1) % capacity;  // Move head when full
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++)
            System.out.print(buffer[(head + i) % capacity] + (i < size - 1 ? ", " : ""));
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3); // Buffer of size 3
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        // Display the result
        cb.display();

        cb.insert(4);
        // Display the result
        cb.display();
    }
}
