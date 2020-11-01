/*
	Question: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	Problem: https://leetcode.com/problems/maximum-subarray/
   
    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over entire array 'n' for every element in array i.e. 'n*n' work
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
    HELP: https://backtobackswe.com/platform/content/max-contiguous-subarray-sum/solutions
*/

class Solution {
    public int maxSubArray(int[] nums) { // Method that returns maximum subarray (sum of array elements) for the following array
        int maximumGlobal = Integer.MIN_VALUE; // Set to (-2147483648) to avoid issues when supplied different arguments i.e. value has to be greater than that always

        for (int i = 0; i < nums.length; i++) { // Iterating over the array
            int maxCurrent = 0; // Stores current sum

            for (int j = i; j < nums.length; j++) { // Iterating over the array
                maxCurrent += nums[j]; // We sum up all elements in array and compare to next iteration (all elements summed in array minus first element etc. - 'i' moves up one place)
                maximumGlobal = Math.max(maximumGlobal, maxCurrent); // Determine largest value between previous value (sum) and current value (sum)
            }
        }
        return maximumGlobal; // Return largest value (sum)
    }
}

/*
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int maxSubArray(int[] nums) { // Method that returns maximum subarray (sum of array elements) for the following array
        int maxCurrent = nums[0]; // Current max subarray
        int maxGlobal = nums[0]; // Global max subarray (overall)

        for(int i=0; i<nums.length; i++) { // Iterate over the array
            // Determine largest value between previous value (sum) and current value (sum) + previous value (no need to iterate twice over array)
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);

            if(maxCurrent > maxGlobal)
            {
                maxGlobal = maxCurrent; // Set maxGlobal as largest sum (subarray) each time we traverse through an element in the array and compare
            }
        }
        return maxGlobal; // Return largest value (sum)
    }
}