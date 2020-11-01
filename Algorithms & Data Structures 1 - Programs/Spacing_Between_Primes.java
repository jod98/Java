/*
 *Question: The goal is to read in a number N and output the distance between the prime number that preceeds it, and the prime that follows it.
 *          If the number itself happens to be prime, then output the distance to the subsequent prime.
 *          For example, if N is 7, then output 4, because the next prime is 11, which is 4 away.
 *
 */


import java.util.Scanner;

public class Spacing_Between_Primes
{
	public static void main(String args[] ) throws Exception
	{
    	Scanner scan = new Scanner(System.in);
    	int num = scan.nextInt();
    	int[] arr = new int[num];
    	int primeCount = 1;
    	arr[0] = 2;

	    for (int i=2; i<(num*2); i++)
	    {
	    	boolean primeTest = true;

	         for (int j=0; j<primeCount && primeTest; j++)
	         {
	         	if (i%arr[j]==0)
	            {
	            	primeTest = false;
	                j = primeCount;
	            }
	         }
	            if (primeTest)
	            {
	                arr[primeCount] = i;
	                primeCount++;
	            }
	        }

	        int higher = 0;
	        int lower = 0;

	        for (int i=0; i<primeCount; i++)
	        {
	            if (arr[i]>num)
	            {
	                higher = arr[i];
	                lower = arr[i-1];
	                i = primeCount;
	            }
	        }

	        int diff = higher - lower;
	        System.out.println(diff);
	    }
	}






