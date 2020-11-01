/*
	Question: Compute and return the square root of x, where x is guaranteed to be a non-negative integer. Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
	Problem: https://leetcode.com/problems/sqrtx/
    
    Time Complexity: O(1) - performing single action on single... not iterating over a series of elements
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=VYtEKhxKd1Q&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int mySqrt(int x) {  // calculate square root of a number
        double squareRoot = Math.sqrt(x);  // 'double' (decimals) variable used to store value of sqrt(x)
        return (int)squareRoot;  // return sqrt(x) casted to an int i.e. truncated
    }
}

/*
    Time Complexity: O(logn) - everytime we are halving a search space
    Space Complexity: O(1) - no memory allocated to data structures
    HELP: https://www.youtube.com/watch?v=VYtEKhxKd1Q&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int mySqrt(int x) {  // calculate square root of a number
        if (x < 2) {  // 0*0 = 0 and 1*1 = 1 therefore no need to perform binary search and can just return the value
            return x;
        }

        long left = 1;  // represents leftmost element of halving
        long right = x;  // represent rightmost element of halving

        while (true) // iterate until we reach our element
        {
            long mid = (left + right)/2;  // Finding midpoint of dataset... has to be long because we are calculating its product while checking

            if (mid * mid > x)  // if current element * itself is greater than 'x' than we need to check the left half (lower values) therefore delete the current right half
            {
                right = mid - 1;  // rightmost element now set to midpoint - 1 (we've checked midpoint value through if statement)
            }
            else  // else current element * itself is less than 'x' so we we check the right half (higher values) and delete the current left half
            {
                left = mid + 1;  // leftmost element now set to midpoint + 1 (we've checked  midpoint value already through else statement)
                if ((mid + 1) * (mid + 1) > x)  // mid^2 was less than x... check about (mid+1) is greater than x? If mid+1 * mid+1 > x therefore... the element has to the current mid value
                    return (int) mid;  // return the sqrt(x) value casted to an int... value truncated not rounded
            }
        }
    }
}
