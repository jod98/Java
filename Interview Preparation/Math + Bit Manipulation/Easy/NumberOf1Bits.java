/*	
	Question: Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
    Problem: https://leetcode.com/problems/number-of-1-bits/
	
    Time Complexity: O(1) - constant number of loop iterations (32) irrespective of input... max bit size of input = 32
    Space Complexity: O(1) -  consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {  // return no. of '1' bits in 'n' (binary format)

        if (n == 0) {  // if input is 0...
            return 0;  // return 0
        }

        int count1s = 0;  // counter which stores number of '1's found in input 'n'
        for(int i=0; i<32; i++) {  // iterate through input 'n' individuals bits (length of 'n' = 32)
            if ((n & 1) == 1)  // // 1&1 = 1, 0&1 = 0... so we can determine what number the bit at 'n' is and add increment to 'count1s'
            {
                count1s++;  // increment value as we have found a '1'
            }
            n >>= 1;  // bitshift 'n' to right by 1 so we can last element i.e. element before everytime (shifted downwards)
        }
        return count1s;  // return number of times '1' appears
    }
}