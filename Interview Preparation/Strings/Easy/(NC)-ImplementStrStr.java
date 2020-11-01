/*
	Question: Return the index of the first occurrence of 'needle' in 'haystack', or -1 if 'needle' is not part of 'haystack'.
	Problem: https://leetcode.com/problems/implement-strstr/
	
    Time Complexity: O(1) - no iterations take place... we simply manipulate string values so it is constant time
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public int strStr(String haystack, String needle) {  

        int returnVal = 0; 

        if (needle.equals("")) {  
            return returnVal; 
        }

        if (haystack.contains(needle)) { 
            returnVal = haystack.indexOf(needle);  
        }

        if (!haystack.contains(needle)) {  
            returnVal = -1; 
        }

        return returnVal; 
    }
}