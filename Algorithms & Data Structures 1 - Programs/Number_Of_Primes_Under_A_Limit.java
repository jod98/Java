/*
 *Question: The goal is to read in a number N and output the number of primes below that number.
 *          For example, if N is 11, then output 4, because there are 4 primes below 11, namely, 2, 3, 5, and 7.
 *
 */

import java.util.Scanner;

public class Number_Of_Primes_Under_A_Limit
{
	public static void main(String args[] ) throws Exception
	{
		Scanner scan = new Scanner(System.in);
    	int num = 0;

        for(int i = scan.nextInt()-1; i >= 2; i--)
        {
        	if(isPrime(i))
        	{
        		num++;
        	}
       	}

    	System.out.print(num);
    }

    	public static boolean isPrime(int num)
    	{
        	for(int i = 2; i <= Math.sqrt(num); i++)
        	{
         	   if(num%i == 0) return false;
        	}

       	 	return true;
    	}
}