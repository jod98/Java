// Initialising Stack Class
public class Stack {
    private int maxSize;                                    // size of stack array
    private int[] stackArray;                               // stack initialised
    private int top;                                        // top of stack

    // Creating Stack Constructor
    public Stack(int s) {
        maxSize = s;                                        // set stack size (array)
        stackArray = new int[maxSize];                      // create stack
        top = -1;                                           // no items yet
    }

    // Insert Item (top of stack)
    public void push(int j) {
        top++;                                              // increment top
        stackArray[top] = j;                                // 'top' value (1st item) = 'j'
    }

    // Remove Item (top of stack)
    public int pop() {
        return stackArray[top--];                           // access item, decrement top
    }

    // Get Item (top of stack)
    public int peek() {
        return stackArray[top];                             // access item
    }

    // Is Stack Empty?
    public boolean isEmpty() {
        return (top == -1);                                 // 'true' if no items
    }

    // Is Stack Full?
    public boolean isFull() {
        return (top == maxSize-1);                          // 'true' if full of items
    }

    // Empty (Delete) Stack
    public void makeEmpty() {
        top = -1;                                           // reset value of 'top' (deletes all items)
    }

    // CALLING METHOD(S): RESULT
    public static void main (String[] args) {
        Stack s1 = new Stack(10);                       // creating stack (size: 10)
        s1.push(20);                                    // inserting '20' at top
        s1.push(80);                                    // inserting '80' at top

        System.out.println(s1.peek());                    // OUTPUT: 80 (top of stack)

        while(!s1.isEmpty()) {
            System.out.println(s1.pop());                 // OUTPUT: 80, 20 (reverse order)
        }
    }
}


