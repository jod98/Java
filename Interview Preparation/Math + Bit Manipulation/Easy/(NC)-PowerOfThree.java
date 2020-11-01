/*
    Question: Given an integer, write a function to determine if it is a power of three.
	Problem: https://leetcode.com/problems/power-of-three/
	
    Time Complexity: O(log3n) -> O(logn) - in this case O(log3n) as we are performing an operation in the while loop that divides 'n' by 3 (tripartite) everytime not iterating through element by element.
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public boolean isPowerOfThree(int n) { 

        if (n < 1) { 
            return false;
        }

        while (n % 3 == 0) {  
            n = n/3;  
        }

        return n == 1;  

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