/*
    Question: The Hamming distance between two integers is the number of positions at which the corresponding bits are different. Given two integers x and y, calculate the Hamming distance.
	Problem: https://leetcode.com/problems/hamming-distance/
	
    Time Complexity: O(1) - constant number of loop iterations is fixed to (32) as that is the max bit size we can have for the integer
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=oGU1At1GFvc&ab_channel=KevinNaughtonJr.
*/

class Solution {
    public int hammingDistance(int x, int y) {  // return number of bit position differences between both 'x' and 'y'
        int countDiff = 0;  // stores number of differences found at each corresponding bit index

        for (int i=0; i<32; i++) {  // iterate through all '32' bits in each value (max binary size of int = 32 bits)
            if (((x & 1) ^ (y & 1)) == 1)  // need the '&' to access the individual bit of the integer... the '& 1' operation has no affect on the bit value... i.e. '1 & 1 = 1'... '0 % 1 = 0'
            {
                countDiff++;  // increment i.e. corresponding bit positions of 'x' and 'y' are different
            }
            x >>= 1;  // bitshift 'x' to right by '1' so we can access the element beforehand i.e. truncating last element
            y >>= 1;  // bitshift 'y' to right by '1' so we can access the element beforehand i.e. truncating last element
        }
        return countDiff;
    }
}