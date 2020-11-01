/*
	Question: Given a 32-bit signed integer, reverse digits of an integer.
	Problem: https://leetcode.com/problems/reverse-integer/
    
    Time Complexity: O(log(x)) - 'base 10' - Not O(n) because 'n' can only have a max size of 10 'Integer.MAX_VALUE + Integer.MIN_VALUE' length. However because we are iterating over every element in the Integer we would still be completing 'n' iterations so that's why it is O(log(x))
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=tm1Yrb_SfBM&ab_channel=FisherCoder
*/

class Solution {
    public int reverse(int x) { // Method to return the reverse of inputted integer i.e. '-123' -> '-321'
        int result = 0; // Stores reversed integer value

        while (x != 0) { // While value of 'x' != 0. Continuously dividing int each iteration to retrieve n-1th element
            int pop = x % 10; // Mod 10 the current 'x' value i.e. '123' -> '12' Remainder 3 i.e. popping element off
            int newResult = (result * 10) + pop; // Adding prev element and curr element to 'result' until we iterated over entire integer value

            /*
            Largest value an Tnteger can hold is: '2147482647' (2^31).
            Smallest value an Tnteger can hold is: '-2147483648' (2^31).

            We compare previous reversed iteration of int to the current one to check if there is a value that exceeds the int capacity i.e.
            Input: 1,534,236,469
            Integer.MAX_VALUE: 2,147,483,647
            Reversed Input: 9,646,324,351 (NOT POSSIBLE) as this value is greater than the max value and Integer can hold... therefore
                            when comparing the individual elements at each iteration we detect a difference and then return 0 (not valid input)

            */
            if ((newResult - pop) / 10 != result) {
                return 0;
            }
            result = newResult; // Storing the reversed integer value at each loop iteration until we have full reversed int
            x = x / 10; // Divide 'x' by 10 so we can retrieve the n-1th part of the number
        }

        return result; // Return the reversed Integer value
    }
}
