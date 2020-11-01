/*
    Question: The Hamming distance between two integers is the number of positions at which the corresponding bits are different. Given two integers x and y, calculate the Hamming distance.
	Problem: https://leetcode.com/problems/hamming-distance/
	
    Time Complexity: O(1) - constant number of loop iterations is fixed to (32) as that is the max bit size we can have for the integer
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public int hammingDistance(int x, int y) {  
        int countDiff = 0; 

        for (int i=0; i<32; i++) { 
            if (((x & 1) ^ (y & 1)) == 1)  
            {
                countDiff++; 
            }
            x >>= 1;  
            y >>= 1;  
        }
        return countDiff;
    }
}