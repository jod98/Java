// Initialising Queue Class
public class Queue {
    private int maxSize;                                    // size of queue array
    private int[] queueArray;                               // queue initialised
    private int front;                                      // front of queue
    private int rear;                                       // rear of queue
    private int nItems;                                     // no. items in queue

    // Creating Queue Constructor
    public Queue(int s) {
        maxSize = s;                                        // set queue size (array)
        queueArray = new int[maxSize];                      // create queue
        front = 0;                                          // nothing at front
        rear = -1;                                          // nothing at rear
        nItems = 0;                                         // no items yet
    }

    // Insert Item (rear of queue)
    public boolean insert(int j) {
        if (isFull())                                       // don't insert if full
            return false;
        if (rear == maxSize-1)                              // deal with wraparound - push elements towards front of queue
            rear = -1;
        rear++;                                             // increment rear
        queueArray[rear] = j;                               // insert item at rear
        nItems++;                                           // increment no. of items
        return true;                                        // successfully inserted
    }

    // Remove Item (front of queue)
    public Number remove() {
        if (isEmpty())                                      // don't remove if empty (return null)
            return null;
        int temp = queueArray[front];                       // get front value
        front ++;                                           // increment front
        if (front == maxSize)                               // deal with wraparound - remove elements from front of queue
            front = 0;
        nItems--;                                           // decrement no. of items
        return temp;                                        // return removed item
    }

    // Get Item (front of queue)
    public int peek() {
        return queueArray[front];                           // access item
    }

    // Is Stack Empty?
    public boolean isEmpty() {
        return (nItems == 0);                               // 'true' if no items
    }

    // Is Queue Full?
    public boolean isFull() {
        return (nItems == maxSize);                         // 'true' if full of items
    }

    // No. of Items in Queue
    public int size() {
        return nItems;                                      // return no. of items in queue
    }

    // PRIORITY QUEUE 'INSERT' EXAMPLE
    public void PriorityQueueInsert(int item) {
        if(nItems == 0)                                     // if: if 0 items, insert at 0
            queueArray[0] = item;
        else {
            int j = nItems;                                 // else: if some items, start at end

            while (j>0 && queueArray[j-1] > item) {         // while new item larger
                queueArray[j] = queueArray[j-1];            // shift upward
                j--;                                        // decrement j
            }
            queueArray[j] = item;                           // insert it
        }
        nItems++;                                           // increase items
    }

    // CALLING METHOD(S): RESULT
    public static void main (String[] args) {
        Queue q1 = new Queue(10);                        // creating queue (size: 10)
        q1.insert(20);                                   // inserting '20' at rear
        q1.insert(80);                                   // inserting '80' at rear

        System.out.println(q1.peek());                     // OUTPUT: 20 (front of queue)

        while(!q1.isEmpty()) {
            System.out.print(q1.remove() + "\t");          // OUTPUT: 20, 80
        }

        ///////////////////////////////////////////////////////////////////////////////////

        Queue pq1 = new Queue(10);                      // creating priority queue (size: 10)
        pq1.PriorityQueueInsert(60);                  // inserting '60' (inserted n sorted)
        pq1.PriorityQueueInsert(20);                  // inserting '20' (inserted n sorted)
        pq1.PriorityQueueInsert(80);                  // inserting '80' (inserted n sorted)
        pq1.PriorityQueueInsert(40);                  // inserting '40' (inserted n sorted)

        while(!pq1.isEmpty()) {
            System.out.print(pq1.remove() + "\t");         // OUTPUT: 20, 40, 60, 80
        }
    }
}


