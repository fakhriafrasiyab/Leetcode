package test;

public class StackImplUsingArray {
    //basic notes:
    //stack is concept that you should to implement it via something such as array, arraylist, linkedlist.
    //via array it is not dynamic behaviour because array is not dynamic.

    int size;
    int arr[];
    int top;

    StackImplUsingArray(int size) {
        this.top = -1;
        this.size = size;
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void push(int newElement) {
        if (!isFull()) {
            top++;
            arr[top] = newElement;
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int deletedElement = top;
            top--;
            return deletedElement;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void printElements() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        StackImplUsingArray stack = new StackImplUsingArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.printElements();
    }
}
