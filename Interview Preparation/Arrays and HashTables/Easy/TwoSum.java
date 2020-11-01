/*
    Time Complexity > Space Complexity.  "Can by memory but cannot buy time (runtime)!"  
*/
/*
	Question: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	Problem: https://leetcode.com/problems/two-sum/
    
    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over entire array 'n' for every element in array i.e. 'n*n' work
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
    HELP: https://www.youtube.com/watch?v=U8B984M1VcU&t=50s&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int[] twoSum(int[] nums, int target) { // Method that returns the indices (index) for two elements that sum to 'target'
        for(int i=0; i<nums.length; i++) { // Iterate over the integers array
            for(int j=i+1; j<nums.length; j++) { // Iterate over the integers array (inside loop)
                if (nums[i] + nums[j] == target) { // If 'i'th and 'j'th element = 'target'...
                    return new int[] {i, j}; // return 'i'th and 'j'th index as array
                }
            }
        }
        /* Indicates method passed illegal argument
           i.e. No two elements add together to equal 'target' */
        throw new IllegalArgumentException("No two sum solution");
    }
}

/*
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
    HELP: https://www.youtube.com/watch?v=Yz_Gc39h5Ls&ab_channel=CodeequalsFUN
*/

class Solution {
    public int[] twoSum(int[] nums, int target) { // Method that returns the indices (index) for two elements that sum to 'target'
        Map<Integer, Integer> map = new HashMap<>(); // HashMap - constant O(1) lookup time and stores key/value pairs (element, index)

        for(int i=0; i<nums.length; i++) { // Iterate over the integers array
            int complement = target - nums[i]; // Attempted to find the element which = target - current element

            if(map.containsKey(complement)) { // If we found the complement in the HashMap
                return new int[] {map.get(complement), i}; // Return the complement element and its index in the array
            }
            map.put(nums[i], i); // Otherwise keep adding current element and index (key/value) pair into HashMap until complement found
        }
        /* Indicates method passed illegal argument
           i.e. No two elements add together to equal 'target' */
        throw new IllegalArgumentException("No two sum solution");
    }
}
