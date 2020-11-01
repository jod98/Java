/*
 *Question: The goal is to read in an int and output the largest int that can be created by bit shifting the original 32-bit number any number of positions
 *			either to the left or the right (i.e. using a single operator, either <<, >> or >>>).


Input Format

An integer which represents n in 32-bit Little Endian format.


Output Format

An integer which is the largest that can be created by bit shifting n to the left or right.


Sample Input

1



Sample Output

1073741824
 *
 */

import java.util.Scanner;

public class Bit_Manipulation_And_Recursion
{
    public static void main(String args[] ) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int largestValue = 0;
        int temp = 0;

        for (int i = 0; i<32; i++)
        {
            temp = n<<i;

            if(temp > largestValue)
            {
            	largestValue = temp;
            }
        }

        for (int i = 0; i<32; i++)
        {
            temp = n>>i;

            if(temp > largestValue)
            {
            	largestValue = temp;
            }
        }

        for (int i = 0; i<32; i++)
        {
            temp = n>>>i;

            if(temp > largestValue)
            {
            	largestValue = temp;
            }
        }

        System.out.println(largestValue);
    }
}