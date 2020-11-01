/*
    Question: Reverse bits of a given 32 bits unsigned integer.
	Problem: https://leetcode.com/problems/reverse-bits/
	
    Time Complexity: O(1) - constant number of loop iterations is fixed to (32) as that is the max bit size we can have for the integer
    Space Complexity: O(1) - consumption of memory is constant regardless of input (no data structures that perform an operation of input)
    HELP: https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {  // return the integer value reversed (in binary format)
        if (n == 0) {  // if input is 0...
            return 0;  // return 0
        }

        int result = 0;  // stores reversed bits
        for (int i = 0; i < 32; i++) {  // iterate through input 'n' individuals bits (length of 'n' = 32)
            result <<= 1;  // bitshift 'result' to left by 1 - as we add the 'n' we push it towards the front through each iteration (initially shifted so we could access last bit)
            if ((n & 1) == 1) {  // 1&1 = 1, 0&1 = 0... so we can determine what number the bit at 'n' is and shift it towards start of 'result'
                result++;  // if it is a '1' then we add '1' to 'result'
            }
            n >>= 1;  // bitshift 'n' to right by 1 so we can last element i.e. element before everytime (shifted downwards) and add to 'result' and then shift it upwards to start of 'result'
        }
        return result;  // return the reversed bits
    }
}