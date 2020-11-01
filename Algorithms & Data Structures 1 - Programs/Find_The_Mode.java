/*
 *Question: Find the Mode of Numbers Inputted
 *
 */

import java.util.*;

public class Find_The_Mode
{
    public static void main(String args[] )
    {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = new int[num];

        for(int i=0;i<num;i++)
        {
            arr[i]=scan.nextInt();
        }

        int record=0;
        int recordnumber=0;
        for(int i=0;i<num;i++)
        {
            int count=0;

            for(int j=0;j<num;j++)
            {
                if(arr[i]==arr[j])
                {
                    count++;
                }
            }

            if(count>record)
            {
                record=count;
                recordnumber=arr[i];
            }
        }
        System.out.println(recordnumber);
    }

}