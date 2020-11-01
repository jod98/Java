/*
	Question: Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
	Problem: https://leetcode.com/problems/majority-element/
    
    Time Complexity: O(n) - where 'n' represents the size of the array as we iterate through 'n' elements
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashmap to store up-to 'n' key/value pairs where 'n' represents number of elements in array
*/

class Solution {
    public int majorityElement(int[] nums) {  

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int majority = 0; 

        for (int i=0; i<nums.length; i++) {  

            if(map.containsKey(nums[i])) { 
                map.put(nums[i], map.get(nums[i]) + 1); 
            }
            if(!map.containsKey(nums[i])) {  
                map.put(nums[i], 1); 
            }
            if (map.containsKey(nums[i]) && map.get(nums[i]) > nums.length /2) {  
                majority = nums[i];  
            }
        }
        return majority; 
    }
}