# 🧩 Data Structure Assignment

**Organization:** Badkul Technology Pvt. Ltd.  
📍 *Registered Office:* H-1, Jiwan Nagar, Karnal, Haryana 132001  
🌐 [www.badkultechnology.com](https://www.badkultechnology.com)  
✉ connect@badkultech.com  

---

## 📘 Overview

This repository contains implementations of fundamental **Data Structures and Algorithms** for the **Data Structure Assignment (September 2025 Batch)** by **Badkul Technology Pvt. Ltd.**  

---

## 🧮 Tasks Overview

### 🧱 **Task 1: Stack and Queue Implementation**

#### **Stack using Array**
```cpp
#include <iostream>
#define SIZE 5
using namespace std;

class Stack {
    int arr[SIZE];
    int top;
public:
    Stack() { top = -1; }

    void push(int val) {
        if (top == SIZE - 1)
            cout << "Stack Overflow\n";
        else
            arr[++top] = val;
    }

    void pop() {
        if (top == -1)
            cout << "Stack Underflow\n";
        else
            top--;
    }

    int peek() {
        return (top == -1) ? -1 : arr[top];
    }

    bool isEmpty() {
        return top == -1;
    }
};

int main() {
    Stack s;
    s.push(10);
    s.push(20);
    cout << "Top element: " << s.peek() << endl;
    s.pop();
    cout << "After pop, Top element: " << s.peek() << endl;
}
```

---

#### **Queue using Array**
```cpp
#include <iostream>
#define SIZE 5
using namespace std;

class Queue {
    int arr[SIZE];
    int front, rear;
public:
    Queue() { front = rear = -1; }

    void enqueue(int val) {
        if (rear == SIZE - 1)
            cout << "Queue Overflow\n";
        else {
            if (front == -1) front = 0;
            arr[++rear] = val;
        }
    }

    void dequeue() {
        if (front == -1 || front > rear)
            cout << "Queue Underflow\n";
        else
            front++;
    }

    int frontElement() {
        return (front == -1 || front > rear) ? -1 : arr[front];
    }

    bool isEmpty() {
        return (front == -1 || front > rear);
    }
};

int main() {
    Queue q;
    q.enqueue(10);
    q.enqueue(20);
    cout << "Front element: " << q.frontElement() << endl;
    q.dequeue();
    cout << "After dequeue, Front element: " << q.frontElement() << endl;
}
```

---

### 🌳 **Task 2: Binary Search Tree (BST)**

```cpp
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
};

Node* createNode(int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->left = newNode->right = nullptr;
    return newNode;
}

Node* insert(Node* root, int value) {
    if (root == nullptr)
        return createNode(value);
    if (value < root->data)
        root->left = insert(root->left, value);
    else
        root->right = insert(root->right, value);
    return root;
}

void inorder(Node* root) {
    if (root != nullptr) {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}

int main() {
    Node* root = nullptr;
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 70);
    insert(root, 20);
    insert(root, 40);

    cout << "Inorder Traversal: ";
    inorder(root);
    cout << endl;
}
```

---

### ⚡ **Task 3: Sorting and Searching Algorithms**

#### **Bubble Sort**
```cpp
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1])
                swap(arr[j], arr[j+1]);
}
```

#### **Quick Sort**
```cpp
int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i+1], arr[high]);
    return i + 1;
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

#### **Binary Search**
```cpp
int binarySearch(int arr[], int l, int r, int x) {
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] < x)
            l = mid + 1;
        else
            r = mid - 1;
    }
    return -1;
}
```

---

## ⚙️ How to Run
1. Clone the repo:
   ```bash
   git clone https://github.com/<your-username>/DS-SEP-2025-<registration-number>.git
   cd DS-SEP-2025-<registration-number>
   ```
2. Compile code:
   ```bash
   g++ filename.cpp -o output
   ./output
   ```
3. Observe the output for each implemented data structure.

---

## 🧠 Key Learning Outcomes
- Stack & Queue implementation using arrays and linked lists  
- BST operations using recursion  
- Sorting and searching algorithm analysis  
- Time complexity understanding (Big-O notation)  

---

## 🧑‍💻 Author
**Name:** *Your Name*  
**Registration Number:** *Your Registration Number*  
**Batch:** DS / SEP 2025  
**Email:** *your.email@example.com*
