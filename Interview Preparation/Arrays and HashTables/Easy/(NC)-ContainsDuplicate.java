/*
    Question: Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
	Problem: https://leetcode.com/problems/contains-duplicate/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an hashset to store up-to 'n' values (worse case scenario)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>(); 
        for(int num : nums) { 

            if(set.contains(num)) {
                return true;  
            }
            else {
                set.add(num); 
            }
        }
        return false; 
    }
}