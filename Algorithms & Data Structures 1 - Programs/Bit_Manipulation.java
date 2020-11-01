/*
 *Question: You are given two ints and are allowed to apply one of the operators &, |, ^ and unlimited uses of the operator ~.
 *			What is the largest int that can be produced given those constraints?


Input Format

Two ints, each on a separate line.


Output Format

The largest int that can be produced using the inputs and the bit manipulation operators.


Sample input

7

4


Sample output

7
 *
 */

import java.util.Scanner;

public class Bit_Manipulation
{
    public static void main(String args[] ) throws Exception
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int k = Integer.MIN_VALUE;

        if((a & b) > k) k =  (a & b);

        if((a ^ b) > k) k =  (a ^ b);

        if((a | b) > k) k =  (a | b);

        if(~(a & b) > k) k = ~(a & b);

        if(~(a ^ b) > k) k = ~(a ^ b);

        if(~(a | b) > k) k = ~(a | b);

        if(~(b & a) > k) k = ~(b & a);

        if(~(b ^ a) > k) k = ~(b ^ a);

        if(~(b | a) > k) k = ~(b | a);

        if((~a & b) > k) k = (~a & b);

        if((~a ^ b) > k) k = (~a ^ b);

        if((~a | b) > k) k = (~a | b);

        if((~b & a) > k) k = (~b & a);

        if((~b ^ a) > k) k = (~b ^ a);

        if((~b | a) > k) k = (~b | a);

        System.out.print(k);
    }
}