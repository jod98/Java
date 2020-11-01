/*
	Question: Write an algorithm to determine if a number n is "happy". Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
	Problem: https://leetcode.com/problems/happy-number/
	
    Time Complexity: O(logn) - https://stackoverflow.com/questions/58977656/how-to-understand-time-complexity-of-happy-number-problem-solution-from-leetcode
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashet to store up-to 'n' values where 'n' represents number of elements in array
*/

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> setSum = new HashSet<Integer>(); 

        while (n != 1) {  
            int current = n; 
            int sum = 0;

            while(current > 0) { 
                sum += (current % 10) * (current % 10); 
                current /= 10;  
            }

            if (setSum.contains(sum)) 
            {
                return false;
            }
            setSum.add(sum); 
            n = sum;  
        }
        return true; 
    }
}