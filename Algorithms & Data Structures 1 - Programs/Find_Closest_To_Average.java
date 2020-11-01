/*
 *Question: Find Closest Number to Average of Inputted Numbers
 *
 */

import java.util.*;

public class Find_Closest_To_Average
{
    public static void main(String args[] )
    {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr =  new int[num];
        double sum=0;

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = scan.nextInt();
            sum = arr[i] + sum;
        }

        double average = (sum/arr.length);
        double closest= Math.abs(arr[0]-average);
        int index = 0;

        for (int j=0; j<arr.length; j++)
        {
            if (Math.abs(arr[j]-average)< closest)
            {
              closest = Math.abs(arr[j]-average);
              index = j;
            }
        }

        System.out.println(arr[index]);

    }

}