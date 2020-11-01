/*
 *Question: Braces in a string are considered to be balanced if the following criteria are met:
·         	For every opening brace (i.e., (, {, or [), there is a matching closing brace (i.e., ), }, or ]) of the same type (i.e., ( matches ), { matches }, and [matches ]).
			An opening brace must appear before (to the left of) its matching closing brace. For example, ]{}[ is not balanced.
·         	No unmatched braces lie between some pair of matched braces. For example, ({[]}) is balanced, but {[}] and [{)] are not balanced.

Complete the braces function in the editor below. It has one parameter: an array of n strings, values. For each string in values, it must determine if all the braces in the string are balanced. The function must return an array of strings where the string at each index i (where 0 = i < n) denotes whether or not all the braces in string valuesi were balanced. If yes, then index i in the return array must contain the string YES; otherwise, index i in the return array must contain the string NO.


Input Format

Locked stub code in the editor reads the following input from stdin:

The first line contains an integer, n, denoting the number of elements in values.

Each line i of the n subsequent lines (where 0 = i < n) contains a string describing valuesi.

The locked stub code then passes the string array values as an argument to the braces() function.


Constraints

·         1 = n = 15

·         1 = length of valuesi = 100

·         It is guaranteed that each valuesi consists of (, ), {, }, [, and ] only.



Output Format

The function must return an array of strings where each index i contains either YES or NO denoting whether or not valuesi was balanced. This is printed to stdout by locked stub code in the editor.



Sample Input 0

2

{}[]()

{[}]}



Sample Output 0

YES

NO



Explanation 0

values0: {}[]() meets the criteria for a balanced string, so index 0 in our return array should contain the string YES.

values1: {[}] contains unmatched braces between a matched pair in the substrings [}, {[}, and [}], so index 1 in our return array should contain the string NO.
 *
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stack
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for(int j = 0; j < num; j++)
        {
            String s1 = scan.next();
            String result = isBalanced(s1);
            System.out.println(result);
        }
        scan.close();
    }

static String isBalanced(String s1)
{
    stack stackBrackets = new stack(1000);
    char input[] = s1.toCharArray();

    if(input.length%2==1)
    {
        return "NO";
    }

    for(int i = 0; i<input.length;i++)
    {

        if(input[i] == '(' || input[i] == '{' || input[i] == '[')
        {
            stackBrackets.push(input[i]);

        }
        else if(stackBrackets.isEmpty() || input[i]!=bracket(stackBrackets.pop()))
        {
            return "NO";
        }

    }

    return stackBrackets.isEmpty() ? "YES" : "NO";
}



public static char bracket(char char_c1)
{
	char c;

	switch(char_c1)
	{

		case '(': c = ')';
		break;

		case '{': c =  '}';
		break;

		case '[': c =  ']';
		break;

		default: c = 'X';
	}
	return c;
}

}

class stack
{
	private int maxSize;
	private char[] stackArray;
	private int top;

	public stack(int s)
	{
			maxSize = s;
			stackArray = new char[maxSize];
			top = -1;
	}

	public void push(char j)
	{
			top++;
			stackArray[top] = j;
	}

	public char pop()
	{
			return stackArray[top--];
	}

	public char peek()
	{
			return stackArray[top];
	}

	public boolean isEmpty()
	{
			return (top == -1);
	}

	public boolean isFull()
	{
			return (top == maxSize-1);
	}

	public void makeEmpty()
	{
			top= -1;
	}
}



