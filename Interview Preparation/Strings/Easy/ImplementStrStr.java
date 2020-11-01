/*
	Question: Return the index of the first occurrence of 'needle' in 'haystack', or -1 if 'needle' is not part of 'haystack'.
	Problem: https://leetcode.com/problems/implement-strstr/
	
    Time Complexity: O(1) - no iterations take place... we simply manipulate string values so it is constant time
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public int strStr(String haystack, String needle) {  // return index in haystack where needle first appears - 'haystack = hello' and 'needle = ll'... value = 2 (first index where needle found)

        int returnVal = 0;  // variable that sets the appropriate return value

        if (needle.equals("")) {  // if needle is an empty string...
            return returnVal;  // return 0
        }

        if (haystack.contains(needle)) {  // if haystack contains string needle...
            returnVal = haystack.indexOf(needle);  // return the index where needle is first seen in haystack
        }

        if (!haystack.contains(needle)) {  // if haystack does not contain string needle...
            returnVal = -1;  // return -1
        }

        return returnVal;  // return the appropriate value
    }
}