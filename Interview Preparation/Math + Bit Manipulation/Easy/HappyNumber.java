/*
	Question: Write an algorithm to determine if a number n is "happy". Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
	Problem: https://leetcode.com/problems/happy-number/
	
    Time Complexity: O(logn) - https://stackoverflow.com/questions/58977656/how-to-understand-time-complexity-of-happy-number-problem-solution-from-leetcode
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashet to store up-to 'n' values where 'n' represents number of elements in array
*/

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> setSum = new HashSet<Integer>();  // every unique item is inserted... when computing sum of squares, if we retrieve the same sum again then we are in a cycle i.e. we are never going to retrieve '1' so return false

        while (n != 1) {  // while value of 'n' != 1...
            int current = n;  // stores current value of 'n'
            int sum = 0;  // stores sum of digits squared

            while(current > 0) {  // while value of 'n' is greater than 0 i.e. while we iterate through all the digits of 'n'
                sum += (current % 10) * (current % 10);  // sum the digits squared
                current /= 10;  // divide current by 10 to retrieve the next digit in the number 'n'
            }

            if (setSum.contains(sum)) // if set contains this sum... then we cycled i.e. it will continue forever so return false
            {
                return false;
            }
            setSum.add(sum);  // otherwise keep adding the sum to 'set'... can only have once instance of sum (unique values only)
            n = sum;  // reset 'n' to value of sum i.e. new value and now iterate over each digit of this new value attempting to find '1'
        }
        return true;  // if the loop breaks 'while (n != 1)' then 'n' has to be '1' because it broke out of the loop i.e. return true
    }
}