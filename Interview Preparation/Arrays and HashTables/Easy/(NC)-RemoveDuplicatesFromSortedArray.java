/*
    Question: Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values and reassign elements of array
*/

class Solution {
    public int removeDuplicates(int[] nums) { 
        if(nums.length == 0) { 
            return 0;
        }

        int i = 0;
        for (int j=1; j<nums.length; j++) { 
            if (nums[i] != nums[j]) { 
                i++; 
                nums[i] = nums[j]; 
            }
        }
        return i + 1; 
    }
}

