/*
    Question: Reverse bits of a given 32 bits unsigned integer.
	Problem: https://leetcode.com/problems/reverse-bits/
	
    Time Complexity: O(1) - constant number of loop iterations is fixed to (32) as that is the max bit size we can have for the integer
    Space Complexity: O(1) - consumption of memory is constant regardless of input (no data structures that perform an operation of input)
*/

public class Solution {
    public int reverseBits(int n) { 
        if (n == 0) {  
            return 0; 
        }

        int result = 0;  
        for (int i = 0; i < 32; i++) {  
            result <<= 1;  
            if ((n & 1) == 1) {  
                result++; 
            }
            n >>= 1; 
        }
        return result;  
    }
}