/*
 *Question: Find Xth Biggest Number
 *
 */

import java.io.*;
import java.util.*;

public class Find_Xth_Biggest_Number
{
    public static void main(String args[] ) throws Exception
    	{
        Scanner scan = new Scanner(System.in);
        int arr[] = {6, 8, 15, 19, 12};
        int num = scan.nextInt();
        
        arr = insertion(arr);
        System.out.println(arr[arr.length-scan.nextInt()]);
    }

    public static int[] insertion(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}

