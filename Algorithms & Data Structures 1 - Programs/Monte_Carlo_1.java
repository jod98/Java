/*
 *Question: The goal is to read in a number of fair coin tosses,
 *          and the probability that a given coin toss will produce heads,
 *          and output the probability that the majority of coin tosses will be heads, rounded to the nearest percent.
 *
 */

import java.util.*;

public class Monte_Carlo_1
{
    public static void main(String[] args)
    {
	     Scanner scan = new Scanner(System.in);
	     double tosses = scan.nextInt();
	     double bias = scan.nextInt();
	     double count=0;
	     double simulations=1000;

	     for(int i=0;i<simulations;i++)
	     {
	     	double total=0;

	        for(int j=0;j<tosses;j++)
	        {
	           if(Math.random()<bias/100.0)
	           {
	           		total++;
	           }
	        }

	        if(total>tosses/2.0)
	        {
	        	count++;
	        }
	      }

	      System.out.println((count*100/simulations));
	 }
}