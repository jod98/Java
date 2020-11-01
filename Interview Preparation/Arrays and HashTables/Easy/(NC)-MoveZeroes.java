/*
	Question: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	Problem: https://leetcode.com/problems/move-zeroes/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values. We simply reassign current array's elements
*/

class Solution {
    public void moveZeroes(int[] nums) { 

        int lastNonZeroIndex = 0; 
        for (int i=0; i<nums.length; i++) { 

            if (nums[i] != 0) {
                swapElements(nums, i, lastNonZeroIndex); 
                lastNonZeroIndex++;
            }
        }
    }
    public void swapElements(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}