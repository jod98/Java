/*
 *Question: The goal is to read in a list of students and their exam scores into an array,
 *          sort the class by their exam scores, and output the name of the student with a particular ranking.


NOTE: You should implement the sorting algorithm yourself, DO NOT use Arrays.sort

TIP: To avoid issues with a scanner when reading a line after reading a number, you can read in the number using Integer.parseInt(scan.nextLine()) where scan in the name of the Scanner you are using.

Input Format

The first line contains n, the number of students. The second line contains r, the ranking to output. This is followed by n pairs of student names and exam scores, each on a separate line.


Output Format

The name of the student who came in rth rank in the class.


Constraints

0=n=100


Sample Input

5

2
Eoin

18
Claire

94
David

34
Dylan

69
John

25


Sample Output

Dylan


Explanation

When sorted by exam scores, the class looks like

94: Claire
69: Dylan
34: David
25: John
18: Eoin


"Dylan" is ranked 2nd.


 *
 */

import java.util.*;

public class Sorting_Strings_2
{
    public static void main(String args[] )
    {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine()), rank = Integer.parseInt(scan.nextLine());
        String[] arr_1 = new String[num];
        int[] arr = new int[num];

        for(int i = 0; i < num; i++)
        {
            arr_1[i] = scan.nextLine();
            arr[i] = Integer.parseInt(scan.nextLine());
        }

        insertion(arr, arr_1);
        System.out.println(arr_1[num-rank]);
    }


    public static void insertion(int[] arr, String[] arr_1)
    {
        for(int i = 0; i < arr.length-1; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    swap(i, j, arr);
                    swap(i, j, arr_1);
                }
            }
        }
    }

    public static void swap(int x, int y, int[] arr)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }



    public static void swap(int x, int y, String[] arr_1)
    {
        String temp = arr_1[x];
        arr_1[x] = arr_1[y];
        arr_1[y] = temp;
    }
}


