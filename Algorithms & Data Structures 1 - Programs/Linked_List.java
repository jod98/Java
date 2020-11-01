/*
 *Question: Go through the double-ended doubly-linked list to find the largest int value held in any of the links.
 *			If the doubly-linked list is empty or defective in any way, return 0.
 *			The main method is already completed, you simply have to write the search() method which reports to the main method.

HINT: Try writing down a couple of defective linked lists, and see what they have in common.

Input Format

There is no input. The linked list is created automatically.


Output Format

Output the largest value held in any of the links. If the linked list is empty or defective output 0.
 *
 */

import java.util.*;

public class Linked_List
{
    public static void main(String args[] ) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int j=0;

		System.out.print("Enter the number of links: ");

        Link[] array = new Link[num];

        for(int i=0;i<num;i++)
        {
        	System.out.print("Enter strings to put in linked list:  ");
            array[i]=new Link(scan.nextLine());
			System.out.println();
        }

        while(j<array.length) //while(myscanner.hasNext()){   //removed hasNext() as it was infinite loop?
        {
            int select=scan.nextInt();
            int next=scan.nextInt();
            if(next!=-1)
            {
                array[select].next=array[next];
            }
			j++;
        }

        LinkedList mylist = new LinkedList();

        if(num>0)
        {
            mylist.first=array[0];
        }
        System.out.println(findLoopLength(mylist));
    }

public static int findLoopLength(LinkedList mylist)
{
        /*return 0 if empty or no loop, otherwise number of links in the loop*/

        Link array[] = new Link[100];
        int i = 0;
        int pos = 0;
        boolean notInserted = true;
        Link current = mylist.first;

		if(current==null)
        {
            return 0;
        }

        array[i] = current;
        i++;

        current = current.next;
        while(notInserted==true)
        {
            pos = search(array,current); //Searches array for link. If not found return -1
            if(pos != -1) 							// If found return position in array.
            {
            	notInserted = false;
            }
            else
			{
				array[i] = current; //add to array
				current = current.next; //move up link
            }
			i++;
        }
        return i - (pos-1);
    }

    public static int search(Link array[], Link key)
	{
		for(int i =0; i<array.length; i++)		//returns where loop begins
		{
				if(array[i] == key)
				{
					return i;
				}
		}

    return -1;
	}
}

class Link
{
	public String data;
	public Link next;

    public Link(String input)
    {
        data=input;
        next=null;
    }
}

class LinkedList
{
	public Link first;

	public LinkedList( )
	{
		first=null;
	}

	public boolean isEmpty( )
	{
		return (first==null);
	}

    public void insertHead(Link insert)
    {
        if(isEmpty())
        {
            first=insert;
        }
        else
        {
            insert.next=first;
            first=insert;
        }
    }
}