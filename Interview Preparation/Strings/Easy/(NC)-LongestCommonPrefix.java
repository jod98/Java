/*
	Question: Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string ""
	Problem: https://leetcode.com/problems/longest-common-prefix/

    Time Complexity: O(n) - where 'n' represents the size of the string array as we iterate through all elements
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {  

        if (strs.length == 0) {  
            return ""; 
        }

        String prefix = strs[0];  

        for (int i=1; i<strs.length; i++) {  
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}