/*
    Time Complexity > Space Complexity.  "Can by memory but cannot buy time (runtime)!"  
*/
/*
	Question: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	Problem: https://leetcode.com/problems/two-sum/
    
    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over entire array 'n' for every element in array i.e. 'n*n' work
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int[] twoSum(int[] nums, int target) { 
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) { 
                    return new int[] {i, j}; 
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
/*
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
    HELP: https://www.youtube.com/watch?v=Yz_Gc39h5Ls&ab_channel=CodeequalsFUN
*/

class Solution {
    public int[] twoSum(int[] nums, int target) { 
        Map<Integer, Integer> map = new HashMap<>(); 

        for(int i=0; i<nums.length; i++) { 
            int complement = target - nums[i]; 

            if(map.containsKey(complement)) { 
                return new int[] {map.get(complement), i}; 
            map.put(nums[i], i); 
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
