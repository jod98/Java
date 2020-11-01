/*
    Question: Write a function that reverses a string. The input string is given as an array of characters char[]. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	Problem: https://leetcode.com/problems/reverse-string/
	
    Time Complexity: O(n) - where 'n' represents the size of the char array as we iterate through all elements
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public void reverseString(char[] s) {  
        int curr = s.length-1;  

        for (int i=0; i<s.length; i++) {  

            if (i >= curr) {  
                break;  
            }
            else {  
                char temp = s[curr];  
                s[curr] = s[i];  
                s[i] = temp;  
                curr--;  
            }
        }
    }
}