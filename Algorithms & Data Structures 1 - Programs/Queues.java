/*
 *Question: Manipulate a priority queue according to the given INSERT and REMOVE commands
 *			and then output the string that is at the front of the priority queue.
 *			If a remove command is issued for an empty queue then nothing should happen.
 *			Inserted strings should be entered into the priority queue according to the length of the string,
 *			with shorter strings at the front of the queue and longer strings at the back.
 *			Where two strings have equal length, positioning should be resolved by alphabetical ordering,
 *			with the words closer to the front of the dictionary (e.g. aardvark, apple) going towards the front of the priority queue,
 *			and the ones closer to the end of the dictionary going towards the back (e.g. zip, zoo).
 *			You should then output the item at the front of the priority queue.

You can implement the priority queue using an array or linked list.

Input Format

An int n indicating the number of instructions, followed by n instructions each on a separate line (either INSERT followed by a string to insert, or REMOVE)


Output Format

Output the string at the front of the priority queue


Constraints

1=n=200


Sample Input

6

INSERT avocado

INSERT lemon

REMOVE

INSERT orange

INSERT kiwi

INSERT apple


Sample Output

kiwi
 *
 */

import java.util.Scanner;

public class Queues
{
	public static void main(String args[] ) throws Exception
	{
		Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Queue PQ = new Queue(num);

        for (int i=0;i<num;i++)
        {
        	String input = scan.nextLine();

            if (input.equals("REMOVE"))
            {
                PQ.remove();
            }
            else
            {
                PQ.insert(input.substring(7,input.length()));
            }
        }
        System.out.println(PQ.peekFront());
    }
}

class Queue
{
    private int maxSize;
    private String[] queArray;
    private int nItems;

    public Queue(int s) // constructor
    {
        maxSize = s;
        queArray = new String[maxSize];
        nItems = 0;
    }

    public void insert(String item) // insert item
    {
        if(nItems==0) // if no items,
        {
            queArray[0] = item;           // insert at 0
        }
        else // if some items,
        {
            int j = nItems;  // start at end

            while(j > 0 && bigger(queArray[j-1],item))// while new item larger
            {
                queArray[j] = queArray[j-1];    // shift upward
                j--;  // decrement j
            }

            queArray[j] = item;                // insert it
        }

        nItems++;                         // increase items
    }

    public boolean bigger(String one, String two)
    {
        if (one.length()<two.length())
        {
            return true;
        }
        else if (one.length()==two.length()&&one.compareTo(two)<0)
        {
            return true;
        }

        return false;

    }

    public String remove() // take item from front of queue
    {
        if(!isEmpty())
        {
            String temp = queArray[nItems];// get value and incr front
            nItems--;                      // one less item
            return temp;
        }
        else
        {
            return null;
        }
    }

    public String peekFront()// peek at front of queue
    {
        if(!isEmpty())
        {
            return queArray[nItems-1];
        }
        else
        {
            return null;
        }
    }

    public boolean isEmpty() // true if queue is empty
    {
        return (nItems==0);
    }

    public boolean isFull() // true if queue is full
    {
        return (nItems==maxSize);
    }

    public int size() // number of items in queue
    {
        return nItems;
    }
}

