/*
	Question: Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
	Problem: https://leetcode.com/problems/single-number/solution/
    
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an hashset to store up-to 'n' values (worse case scenario)
    HELP: https://www.youtube.com/watch?v=m8QvwmfJwvA&ab_channel=TerribleWhiteboard
*/

class Solution {
    public int singleNumber(int[] nums) { 
        Set<Integer> set = new HashSet(); 

        for (int num : nums) { 

            if (!set.contains(num)) { 
                set.add(num);
            }
            else {
                set.add(num); 
            }
        }
        return set.iterator().next(); 
    }
}
