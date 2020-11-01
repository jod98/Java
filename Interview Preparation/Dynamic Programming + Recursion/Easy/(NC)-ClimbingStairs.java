/*
    Question: You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	Problem: https://leetcode.com/problems/climbing-stairs/
	
    Time Complexity: O(2^n) i.e. n(5) = 32 possibilities of steps i.e. '1+1+1+1+1', '1+1+1+2' etc. (WE RECOMPUTE PREVIOUS ANSWER I.E. INEFFICIENT)
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
*/

class Solution {
    public int climbStairs(int n) {  
        return climbStairsHelper(n);  
    }

    private int climbStairsHelper(int n) {
        if (n < 0) {  
            return 0;
        }
        if (n == 0) { 
            return 1;
        }
        return climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
    }
}
/*
    "Memoisation" = optimization technique used primarily to speed up computer programs by storing the results of expensive function calls and returning the cached result when the same inputs occur again

    Time Complexity: O(n) - where 'n' represents input value 'n'... we iterate down to size of recursion tree upto 'n' (WE DON'T RECOMPUTE PREVIOUS ANSWER, we cache result in memo array)
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
*/

class Solution {
    public int climbStairs(int n) {  
        int memo[] = new int[n + 1];  
        return climbStairsHelper(n, memo); 
    }

    private int climbStairsHelper(int n, int memo[]) {  
        if (n < 0) {  
            return 0;
        }
        if (n == 0) {  
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n]; 
        }
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];  
    }
}
