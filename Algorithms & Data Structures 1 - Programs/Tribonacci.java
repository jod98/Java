/*
 *Question: The well known Fibonnaci sequence is defined Fn = F(n-1) + F(n-2) with seed values 0 and 1 for the first two terms,
 *			giving rise to the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34... where every term is the sum of the two terms before it.
 *			Let's invent a "Tribonnaci" sequence where Fn = F(n-1) + F(n-2) + F(n-3) and the first three terms are F(0)=0, F(1)=0 and F(2)=1.
 *			Given an input number n, find the nth term of the "Tribonnaci" sequence.


You can choose to use recursion (with dynamic programming), or you can use a less elegant method!


Input Format

An integer n


Output Format

A long which is the nth term of the Tribonnaci sequence


Constraints

0=n=70


Sample input

3


Sample output

1
 *
 */

import java.util.Scanner;

public class Tribonacci
{
    public static void main(String args[] ) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long fib[] = new long [n+2];

        fib[0] = 0;
        fib[1] = 0;
        fib[2] = 1;

        System.out.println(fibTD(n, fib));
    }

    public static long fibTD(int n, long fib[])
    {
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }
        if(fib[n]!=0)
        {
        	return fib[n];
        }
        else
        {
            fib[n]= fibTD(n-1, fib) + fibTD(n-2, fib) + fibTD(n-3, fib);
            return fib[n];
        }
    }
}