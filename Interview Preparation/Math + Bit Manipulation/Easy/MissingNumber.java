/*
	Question: Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
	Problem: https://leetcode.com/problems/missing-number/
    
    Time Complexity: O(n) - where 'n' represents the size of the array as we iterate through 'n' elements
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashset to store up-to 'n' values where 'n' represents size of input array
    HELP: https://www.youtube.com/watch?v=YMYVYSWL93w&ab_channel=KevinNaughtonJr.
*/

public class Solution {
    public int missingNumber(int[] nums) {  // returning missing number in sequence (array)

        HashSet<Integer> set = new HashSet<Integer>();  // store unique integer values... allows us to compare each index with each hashset element and if its not there then.. that's missing number
        int missingNum = 0;  // returns missing number

        for(int i: nums) {  // iterate through all array elements...
            set.add(i);  // add to hashset
        }

        for (int i=0; i <= nums.length; i++) {  // iterate though from index '0 - n' (and including 'n' there '<=')

            if(!set.contains(i)) {  // if set does not contain current index i.e. '0,1,2,3' etc. then 'i' (current index) is the missing number from array sequence
                missingNum = i;  // set missing num to '1'
                return missingNum;  // return missing number
            }
        }
        return -1; // using '-1' to denote the fact there is no natural number missing in array i.e. '-1' cannot be in array considering it ranges from '0 - n'
    }
}