 // ==============================
// Task 1: Stack & Queue
// ==============================

public class Task1 {

    // ---- Stack using Array ----
    static class StackArray {
        private int[] stack;
        private int top;
        private int capacity;

        public StackArray(int size) {
            stack = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int value) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            stack[++top] = value;
            System.out.println("Pushed into StackArray: " + value);
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = stack[top--];
            System.out.println("Popped from StackArray: " + val);
            return val;
        }

        public int peek() {
            int val = isEmpty() ? -1 : stack[top];
            System.out.println("Peek in StackArray: " + val);
            return val;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // ---- Stack using Linked List ----
    static class StackLinkedList {
        static class Node {
            int data;
            Node next;
            Node(int d) { data = d; }
        }

        private Node top;

        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            System.out.println("Pushed into StackLinkedList: " + value);
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = top.data;
            top = top.next;
            System.out.println("Popped from StackLinkedList: " + val);
            return val;
        }

        public int peek() {
            int val = isEmpty() ? -1 : top.data;
            System.out.println("Peek in StackLinkedList: " + val);
            return val;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    // ---- Queue using Array ----
    static class QueueArray {
        private int[] queue;
        private int front, rear, size, capacity;

        public QueueArray(int capacity) {
            this.capacity = capacity;
            queue = new int[capacity];
            front = size = 0;
            rear = capacity - 1;
        }

        public void enqueue(int value) {
            if (size == capacity) {
                System.out.println("Queue Overflow");
                return;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            System.out.println("Enqueued into QueueArray: " + value);
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Dequeued from QueueArray: " + val);
            return val;
        }

        public int front() {
            int val = isEmpty() ? -1 : queue[front];
            System.out.println("Front in QueueArray: " + val);
            return val;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    // ---- Queue using Linked List ----
    static class QueueLinkedList {
        static class Node {
            int data;
            Node next;
            Node(int d) { data = d; }
        }

        private Node front, rear;

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            System.out.println("Enqueued into QueueLinkedList: " + value);
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = front.data;
            front = front.next;
            if (front == null) rear = null;
            System.out.println("Dequeued from QueueLinkedList: " + val);
            return val;
        }

        public int front() {
            int val = isEmpty() ? -1 : front.data;
            System.out.println("Front in QueueLinkedList: " + val);
            return val;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    // ---- Main Method to test ----
    public static void main(String[] args) {
        System.out.println("==== Stack using Array ====");
        StackArray sa = new StackArray(5);
        sa.push(10);
        sa.push(20);
        sa.peek();
        sa.pop();
        sa.pop();
        sa.pop(); // underflow
        System.out.println("Is StackArray Empty? " + sa.isEmpty());

        System.out.println("\n==== Stack using Linked List ====");
        StackLinkedList sl = new StackLinkedList();
        sl.push(30);
        sl.push(40);
        sl.peek();
        sl.pop();
        sl.pop();
        sl.pop(); // underflow
        System.out.println("Is StackLinkedList Empty? " + sl.isEmpty());

        System.out.println("\n==== Queue using Array ====");
        QueueArray qa = new QueueArray(3);
        qa.enqueue(1);
        qa.enqueue(2);
        qa.enqueue(3);
        qa.enqueue(4); // overflow
        qa.front();
        qa.dequeue();
        qa.dequeue();
        qa.dequeue();
        qa.dequeue(); // underflow
        System.out.println("Is QueueArray Empty? " + qa.isEmpty());

        System.out.println("\n==== Queue using Linked List ====");
        QueueLinkedList ql = new QueueLinkedList();
        ql.enqueue(5);
        ql.enqueue(6);
        ql.front();
        ql.dequeue();
        ql.dequeue();
        ql.dequeue(); // underflow
        System.out.println("Is QueueLinkedList Empty? " + ql.isEmpty());
    }
}
