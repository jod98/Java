/*
	Question: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	Problem: https://leetcode.com/problems/move-zeroes/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values. We simply reassign current array's elements
*/

class Solution {
    public void moveZeroes(int[] nums) { // Method that will return sorted matrix ('0's to the end)

        int lastNonZeroIndex = 0; // Keeps track of the index of the last inserted non-zero value
        for (int i=0; i<nums.length; i++) { // Iterate through all array elements

            if (nums[i] != 0) { // If current element != 0
                swapElements(nums, i, lastNonZeroIndex); // Swap curr element with the index+1 of the last inserted non-zero value
                lastNonZeroIndex++; // Increment index to avoid us swapping correctly placed non-zero value
            }
        }
    }
    public void swapElements(int arr[], int a, int b) { // Method that will allow us to swap array elements
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}