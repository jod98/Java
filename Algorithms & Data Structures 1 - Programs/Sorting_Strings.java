/*
 *Question: In this task the input is two numbers, followed by a series of strings.
 *			Those strings must be sorted and then one particular string must be outputted.
 *			The first number denotes the quantity of strings to follow.
 *			The second number indicates which string should be outputted following the sort.
 *			For example, if it's a 3, then output the string that falls in third place.
 *			If it's a 5 then output the string that falls in fifth place.
 *
 *The sorting that should be applied is as follows: sort words by their length, with the shortest words coming first. If two words have the same length, then sort them in reverse alphabetical order (i.e. with "zoo" coming ahead of "ape").
 *
 *NOTE: You should implement the sorting algorithm yourself, DO NOT use Arrays.sort.
 *
 *Input Format

The first line is an int n indicating the quantity of strings

The second line is an int r indicating the ranking to be outputted following the sort

This is followed by n Strings each on a separate line



Output Format

Output the string ranked in rth place following the sort


Constraints

1=n=1000


Sample Input

6

3

this

is

how

to

do

it


Sample Output

is


Explanation

When sorted the words are

to

it

is

do

how

this


The 3rd words in the list is "is"
 *
 */

import java.util.*;

public class Sorting_Strings
{
    public static void main (String[]args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.print("Number of strings: ");
        int n = scan.nextInt();         //read n = quantity of strings
        System.out.print("Position to be outputted: ");
        int r = scan.nextInt();         //read r = ranking output
        scan.nextLine();
        String[]strings = new String[n];            //read strings

        for(int i = 0; i<strings.length; i++)
        {
            strings[i]= scan.nextLine();
        }

        sort(strings);                              //sort strings
        System.out.println("The string at position " + r + " is " + strings[r-1]);           //print strings
    }

    public static void sort (String[]strings)
    {
        for(int j = 0; j < strings.length - 1; j++)
        {
            int min = j;

            for(int i = j + 1; i < strings.length; i++) //find min
            {
                if(compare(strings[i], strings[min])<0)
                {
                    min = i;
                }
            }

            if(min != j) //Swap if need to
            {
                String temp = strings[min];
                strings[min] = strings[j];
                strings[j] = temp;
            }
        }
    }

    public static int compare (String s1, String s2) //compare strings
    {
        int compare = s1.length() - s2.length();                //compare length
        if(compare==0)
        {
            compare = s2.compareTo(s1); //if its the same, compare by reverse alphabetically

        }

        return compare;
    }
}

