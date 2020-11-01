/*
    Question: You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	Problem: https://leetcode.com/problems/climbing-stairs/
	
    Time Complexity: O(2^n) i.e. n(5) = 32 possibilities of steps i.e. '1+1+1+1+1', '1+1+1+2' etc. (WE RECOMPUTE PREVIOUS ANSWER I.E. INEFFICIENT)
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
    HELP: https://www.youtube.com/watch?v=NFJ3m9a1oJQ&ab_channel=BackToBackSWE
*/

class Solution {
    public int climbStairs(int n) {  // method that returns the total number of ways of climbing a set of stairs using 1-step or 2-step variants
        return climbStairsHelper(n);  // return the value from the private function below which will calculate the total number of possibilities
    }

    private int climbStairsHelper(int n) {
        if (n < 0) {  // 0 distinct ways to climb -n steps (impossible to take negative step)...
            return 0;
        }
        if (n == 0) {  // 1 distinct way to climb 0 steps (not take a step at all)...
            return 1;
        }
        // answer to subproblem: sum of answer to subproblem 'n-1' + subproblem 'n-2'... This drills towards base case which provides results and builds up answer
        return climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
    }
}

/*
    "Memoisation" = optimization technique used primarily to speed up computer programs by storing the results of expensive function calls and returning the cached result when the same inputs occur again

    Time Complexity: O(n) - where 'n' represents input value 'n'... we iterate down to size of recursion tree upto 'n' (WE DON'T RECOMPUTE PREVIOUS ANSWER, we cache result in memo array)
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
*/

class Solution {
    public int climbStairs(int n) {  // method that returns the total number of ways of climbing a set of stairs using 1-step or 2-step variants
        int memo[] = new int[n + 1];  // 'memo' array helps prune recursion tree and reduce size of recursion upto 'n'. Size = 'n+1' because 'n' will represent index so we will be in the bounds.
        return climbStairsHelper(n, memo);  // return the value from the private function below which will calculate the total number of possibilities
    }

    private int climbStairsHelper(int n, int memo[]) {  // passing in 'memo' array so we can store previously computed value to prevent recomputing again - redundant
        if (n < 0) {  // 0 distinct ways to climb -n steps (impossible to take negative step)...
            return 0;
        }
        if (n == 0) {  // 1 distinct way to climb 0 steps (not take a step at all)...
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];  // if we already have answer for this subproblem... then just return the cached result.. don't recompute it
        }
        // answer to subproblem: sum of answer to subproblem 'n-1' + subproblem 'n-2'... This drills towards base case which provides results and builds up answer
        // answer is also cached at each iteration to ensure that we don't recompute result in future
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];  // return
    }
}
