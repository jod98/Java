/*
	Question: Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
	Problem: https://leetcode.com/problems/missing-number/
    
    Time Complexity: O(n) - where 'n' represents the size of the array as we iterate through 'n' elements
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashset to store up-to 'n' values where 'n' represents size of input array
*/

public class Solution {
    public int missingNumber(int[] nums) { 

        HashSet<Integer> set = new HashSet<Integer>();  
        int missingNum = 0;  

        for(int i: nums) { 
            set.add(i); 
        }

        for (int i=0; i <= nums.length; i++) {  

            if(!set.contains(i)) { 
                missingNum = i;
                return missingNum; 
            }
        }
        return -1; 
    }
}