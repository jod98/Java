/*
	Question: Compute and return the square root of x, where x is guaranteed to be a non-negative integer. Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
	Problem: https://leetcode.com/problems/sqrtx/
    
    Time Complexity: O(1) - performing single action on single... not iterating over a series of elements
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public int mySqrt(int x) { 
        double squareRoot = Math.sqrt(x);  
        return (int)squareRoot; 
    }
}

/*
    Time Complexity: O(logn) - everytime we are halving a search space
    Space Complexity: O(1) - no memory allocated to data structures
    HELP: https://www.youtube.com/watch?v=VYtEKhxKd1Q&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int mySqrt(int x) { 
        if (x < 2) { 
            return x;
        }

        long left = 1;  
        long right = x;  

        while (true) 
        {
            long mid = (left + right)/2;  

            if (mid * mid > x)  
            {
                right = mid - 1;
            }
            else  
            {
                left = mid + 1;  
                if ((mid + 1) * (mid + 1) > x)  
                    return (int) mid;  
            }
        }
    }
}
