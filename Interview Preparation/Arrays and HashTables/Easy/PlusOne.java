/*
    Question: Given a non-empty array of digits representing a non-negative integer, increment one to the integer. i.e. if array = [9,9,9] then array+1 = [1,0,0,0]
	Problem: https://leetcode.com/problems/plus-one/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an array to store all the incremented value (only if array = 999 then new array created (len+1) to store 1000)
    HELP: https://www.youtube.com/watch?v=G737jzcxG9A&ab_channel=NickWhite
*/

class Solution {
    public int[] plusOne(int[] digits) { // Method that returns the array value incremented by 1 i.e. 1,2,9 -> 1,3,0 (roll over)
        for(int i=digits.length-1; i>=0; i--) { // Iterating through array from back to front (incrementing last digit)

            if(digits[i] < 9) { // If current element > 9
                digits[i]++; // Then increment element i.e. 2 -> 3
                return digits; // Return updated digits array
            }
            digits[i] = 0; // Otherwise, current element = 9... so we set = 0 and increment element before (i-1)
        }
        // If digits[] = {9, 9, 9} then we create another array (one size bigger) i.e. {1, 0, 0, 0}
        int newDigits[] = new int [digits.length+1]; // Create new digits array (one element larger)
        newDigits[0] = 1; // Set first element = 1 as following elements are all 9
        return newDigits; // Return updated digits array
    }
}