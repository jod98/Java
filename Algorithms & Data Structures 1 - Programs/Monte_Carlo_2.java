/*
 *Question: The goal is to read in a number of fair coin tosses, and a target number of heads,
 *          and output the probability that the target number of heads in a row will be tossed at some point in the sequence,
 *          rounded to the nearest percent.
 *
 */

import java.util.*;

public class Monte_Carlo_2
{
	public static void main(String[] args)
	{
        Scanner scan = new Scanner(System.in);
        int tosses = scan.nextInt();
        int heads = scan.nextInt();
        double count=0;
        double simulations=1000000;

        for(int i=0;i<simulations;i++)
        {
        	int click=0;
            int record=0;

            for(int j=0;j<tosses;j++)
            {
            	if(Math.random()>.5)
            	{
                    click++;

                    if(click>record)
                    {
                    	record=click;
                    }

                }
                else
                {
                    click=0;
                }
            }

            if(record>=heads)
            {
                count++;
            }
        }

        System.out.println((count*100/simulations));
    }
}