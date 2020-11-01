/*	
	Question: Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
    Problem: https://leetcode.com/problems/number-of-1-bits/
	
    Time Complexity: O(1) - constant number of loop iterations (32) irrespective of input... max bit size of input = 32
    Space Complexity: O(1) -  consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

public class Solution {
    public int hammingWeight(int n) { 

        if (n == 0) { 
            return 0; 
        }

        int count1s = 0;  
        for(int i=0; i<32; i++) { 
            if ((n & 1) == 1)  
            {
                count1s++;  
            }
            n >>= 1; 
        }
        return count1s; 
    }
}