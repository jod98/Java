/*
    Question: Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values and reassign elements of array
    HELP: https://www.youtube.com/watch?v=rlfsnRY0S9k&t=485s&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int removeDuplicates(int[] nums) { // Method that returns updated array (all unique elements at front - swapped)
        if(nums.length == 0) { // Check if array size > 0 (has elements)
            return 0;
        }

        int i = 0; // Variable used to compare elements
        for (int j=1; j<nums.length; j++) { // Iterate over the array
            if (nums[i] != nums[j]) { // If 'i'th value and 'j'th elements not equal
                i++; // Increment 'i' - will allow us to replace the current element (duplicate)
                nums[i] = nums[j]; // Swap the duplicate element for next unique element
            }
        }
        return i + 1; // 'i'th index is currently on last unique element therefore with add '1' to return new array length
    }
}

