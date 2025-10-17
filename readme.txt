
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
