/*
 *Question: Write a recursive method that takes in a bank account balance x, an interest rate i and a number of years y,
 *			and outputs how much the bank account will be worth after y years.
 *			For example, if you invest €100 at 2% annual interest,
 *			then after year 1 you have €102.00, after year 2 you have €104.04, after year 3 you have €106.12 and so forth.


Input Format

The main method, which is already written, takes in a bank account balance as a double, x, interest percentage rate as a double, i, and the number of years for which it is being invested, y.


Output Format

A double representing how much the bank account is worth after y years, correct to two decimal places.


Constraints

1=y=30

0.0%=i=100.0%

0=x=1000000


Sample input

7

1.3

100


Sample output

109.46

(courtesy of Peter Beattie)
 *
 */

import java.util.Scanner;

public class Recursive_Bank_Account_Balance
{
    public static void main(String args[] )
    {
        Scanner scan = new Scanner(System.in);
        int y = scan.nextInt();
        double i = scan.nextDouble();
        double x = scan.nextDouble();
        System.out.println(String.format( "%.2f", compound(y,i,x)));
    }

    public static double compound(int y, double i, double x)
    {
    	if(y == 0)
    	{
    		return x;
    	}

		double factor = (i/100) + 1;
		int one = y-1;
		double two = i;
		double three = x;
		return (factor*compound(one, two, three));
    }
}

