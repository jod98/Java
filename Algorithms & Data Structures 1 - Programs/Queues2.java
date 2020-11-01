/*
 *Question: Manipulate a queue according to the given insert and remove commands
 *			and then output the string that is at the front of the queue.
 *			If a remove command is issued for an empty queue then nothing should happen.


Input Format

A series of lines involving either INSERT or REMOVE commands. The command INSERT is followed by a space and then the string to insert (e.g. INSERT hello).


Output Format

Output the string that is at the front of the queue following the given commands. If the queue is empty output "empty".


Constraints

1=#(commands)=20

1=length(string)=20


Sample Input

INSERT yes

INSERT we

REMOVE

INSERT can

REMOVE


Sample Output

can
 *
 */


import java.util.Scanner;

public class Queues_2
{
    public static void main(String args[] ) throws Exception
    {
       Scanner scan=new Scanner(System.in);
       String command;
       Queue myQ = new Queue(20);
       String array[] = new String[20];

       while(scan.hasNext())
       {
       	  command=scan.nextLine();
          array=command.split(" ");

          if(array[0].equalsIgnoreCase("INSERT"))
          {
          	myQ.insert(array[1]);
          }
          else
          {
          	if(!myQ.isEmpty())
          	{
          		myQ.remove();
            }
          }
        }

        if(myQ.isEmpty())
        {
        	System.out.println( "empty");
        }
        else
        {
        	System.out.println( myQ.remove());
        }
      }
}

class Queue
{
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s)
    {
        maxSize = s;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean insert(String item)
    {
        if(!isFull())
        {
            rear++;
            queArray[rear]=item;
            nItems++;
            return true;
        }else
        {
            return false;
        }
    }

    public String remove()
    {
        String temp = queArray[front];
        front++;

        if(front == maxSize)
        {
        	front = 0;
        }

        nItems--;
        return temp;
    }

    public boolean isEmpty()
    {
        return (nItems==0);
    }

    public boolean isFull()
    {
        return (nItems==maxSize);
    }

    public int size()
    {
        return nItems;
    }
}

