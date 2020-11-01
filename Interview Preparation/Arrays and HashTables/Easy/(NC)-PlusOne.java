/*
    Question: Given a non-empty array of digits representing a non-negative integer, increment one to the integer. i.e. if array = [9,9,9] then array+1 = [1,0,0,0]
	Problem: https://leetcode.com/problems/plus-one/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an array to store all the incremented value (only if array = 999 then new array created (len+1) to store 1000)
*/

class Solution {
    public int[] plusOne(int[] digits) { 
        for(int i=digits.length-1; i>=0; i--) { 

            if(digits[i] < 9) {
                digits[i]++; 
                return digits; 
            }
            digits[i] = 0;
        }
        int newDigits[] = new int [digits.length+1]; 
        newDigits[0] = 1; 
        return newDigits; 
    }
}