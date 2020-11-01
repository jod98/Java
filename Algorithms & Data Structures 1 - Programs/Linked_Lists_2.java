/*
 *Question:
 *
 */


public static int findLoopLength(LinkedList myList)
{
   if(myList.isEmpty())
   {
   		return 0;
   }

   Link current = myList.first;
   int count = 0;
   Link arr[] = new Link[100];

   while(current.next != null)
   {
   		arr[count] = current;

        for(int i = 0; i < count; i++)
        {
        	if(arr[i] == current)
        	{
                    return count-i;
        	}
        }
            count++;
            current = current.next;
        }

        return 0;
}

