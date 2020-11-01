/*
    Question: Given an integer, write a function to determine if it is a power of three.
	Problem: https://leetcode.com/problems/power-of-three/
	
    Time Complexity: O(log3n) -> O(logn) - in this case O(log3n) as we are performing an operation in the while loop that divides 'n' by 3 (tripartite) everytime not iterating through element by element.
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public boolean isPowerOfThree(int n) {  // return true/false if 'n' is/not a power of 3 i.e. multiple of 3

        if (n < 1) {  // if n < 1... then eliminate 0 and negative numbers
            return false;
        }

        while (n % 3 == 0) {  // mod 'n' by 3 to determine if 'n' is a multiple (power of three)...
            n = n/3;  // keep diving until we reach 3 i.e. '3/3 = 1' as 'n' could have been just a multiple of '6' but not '3'
        }

        return n == 1;  // returns true if n == 1, returns false otherwise

        /* Above return statement is same as...
        if (n == 1) {
            return true;
        }
        else {
            return false;
        }
        */
    }
}