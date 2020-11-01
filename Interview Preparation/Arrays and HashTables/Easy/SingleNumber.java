/*
	Question: Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
	Problem: https://leetcode.com/problems/single-number/solution/
    
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an hashset to store up-to 'n' values (worse case scenario)
    HELP: https://www.youtube.com/watch?v=m8QvwmfJwvA&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int singleNumber(int[] nums) { // Return the non-duplicate number in the array
        Set<Integer> set = new HashSet(); // Creating a HashSet - class that only contains unique numbers using hashing method (no duplicates)

        for (int num : nums) { // Iterating through all elements in array

            if (!set.contains(num)) { // If set contain current element
                set.add(num); // Remove element from set (i.e. number that appear 2*, 4*, 6* etc. will be removed)
            }
            else { // If set !contain current element
                set.add(num); // Add the element to the set
            }
        }
        return set.iterator().next(); // Return non-duplicate element in array (first element in HashSet)
    }
}
