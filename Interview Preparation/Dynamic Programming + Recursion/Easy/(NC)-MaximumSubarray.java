/*
	Question: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	Problem: https://leetcode.com/problems/maximum-subarray/
   
    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over entire array 'n' for every element in array i.e. 'n*n' work
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int maxSubArray(int[] nums) { 
        int maximumGlobal = Integer.MIN_VALUE; 

        for (int i = 0; i < nums.length; i++) { 
            int maxCurrent = 0; 

            for (int j = i; j < nums.length; j++) { 
                maxCurrent += nums[j]; 
                maximumGlobal = Math.max(maximumGlobal, maxCurrent); 
            }
        }
        return maximumGlobal; 
    }
}
/*
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int maxSubArray(int[] nums) { 
        int maxCurrent = nums[0]; 
        int maxGlobal = nums[0];

        for(int i=0; i<nums.length; i++) { 
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);

            if(maxCurrent > maxGlobal)
            {
                maxGlobal = maxCurrent; 
            }
        }
        return maxGlobal; 
    }
}