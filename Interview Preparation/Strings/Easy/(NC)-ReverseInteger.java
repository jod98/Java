/*
	Question: Given a 32-bit signed integer, reverse digits of an integer.
	Problem: https://leetcode.com/problems/reverse-integer/
    
    Time Complexity: O(log(x)) - 'base 10' - Not O(n) because 'n' can only have a max size of 10 'Integer.MAX_VALUE + Integer.MIN_VALUE' length. However because we are iterating over every element in the Integer we would still be completing 'n' iterations so that's why it is O(log(x))
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public int reverse(int x) { 
        int result = 0; 

        while (x != 0) { 
            int pop = x % 10; 
            int newResult = (result * 10) + pop; 

            if ((newResult - pop) / 10 != result) {
                return 0;
            }
            result = newResult; 
            x = x / 10; 
        }

        return result; 
    }
}
