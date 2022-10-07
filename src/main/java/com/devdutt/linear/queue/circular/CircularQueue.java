package com.devdutt.linear.queue.circular;
/*Time complexity:-
  Insertion:- O(1)
  Deletion:-  O(1)
  Peek:-  O(1)
* */
public class CircularQueue {
    int arr[] = null;
    int capacity = 5;
    int rear = -1;
    int front = -1;

    public CircularQueue() {
        this.arr = new int[capacity];
    }

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        //1st element add
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is removed");
            return -1;
        }
        int result = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is removed");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.enqueue(20);
        System.out.println("Peek:- " + cq.peek());
        cq.enqueue(40);
        cq.enqueue(10);
        cq.enqueue(30);
        cq.enqueue(50);
        System.out.println("Peek:- " + cq.peek());
        cq.enqueue(60);
        System.out.println("==============================");
        System.out.println(cq.dequeue());
        System.out.println("Peek:- " + cq.peek());
    }
}
