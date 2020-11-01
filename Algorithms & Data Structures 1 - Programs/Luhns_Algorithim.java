/*
 *Question: Checking whether credit card number is 'VALID' or 'INVALID'
 *          using Luhn's Algorithim (Mod 10 algorithim)
 *
 *			https://www.youtube.com/watch?v=PNXXqzU4YnM&t
 *
 */

import java.util.Scanner;

public class Luhns_Algorithim
{
	public static void main(String args [])
	{
		Scanner scan = new Scanner(System.in);
		String ccNumber = scan.nextLine();
		//System.out.println(Check(ccNumber));

		//If I want to print out VALID or INVALID
		if(Check(ccNumber) == true)
		{
			System.out.println("VALID");
		}
		else
		{
			System.out.println("INVALID");
		}

	}
	public static boolean Check(String ccNumber)
	{
		int sum = 0;
		boolean alternate = false;
		for (int i = ccNumber.length() - 1; i >= 0; i--)
		{
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate)
			{
				n *= 2;
				if (n > 9)
				{
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}
}