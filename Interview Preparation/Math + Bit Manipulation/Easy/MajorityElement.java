/*
	Question: Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
	Problem: https://leetcode.com/problems/majority-element/
    
    Time Complexity: O(n) - where 'n' represents the size of the array as we iterate through 'n' elements
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashmap to store up-to 'n' key/value pairs where 'n' represents number of elements in array
    HELP: https://www.youtube.com/watch?v=q-xu9rbfrq4&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int majorityElement(int[] nums) {  // returns the element which appears more than n/2 times where 'n' is length of array

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  // create a hashmap to store array element and number of times it appears
        int majority = 0;  // stores majority element

        for (int i=0; i<nums.length; i++) {  // iterate through array

            if(map.containsKey(nums[i])) { // if map contains current element then...
                map.put(nums[i], map.get(nums[i]) + 1);  // 'put' / increment the number of times it appears i.e. count
            }
            if(!map.containsKey(nums[i])) {  // if map dosen't contain current element (start of array or another element) then...
                map.put(nums[i], 1);  //  add current element to hashmap with count = 1 (only recorded one time so far)
            }
            if (map.containsKey(nums[i]) && map.get(nums[i]) > nums.length /2) {  // if map contains current element & count value of current element is greater than n/2 (appears in over half the elements in array)
                majority = nums[i];  // set majority = current element (majority element)
            }
        }
        return majority; // return majority element
    }
}