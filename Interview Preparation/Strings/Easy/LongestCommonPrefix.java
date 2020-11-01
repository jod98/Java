/*
	Question: Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string ""
	Problem: https://leetcode.com/problems/longest-common-prefix/

    Time Complexity: O(n) - where 'n' represents the size of the string array as we iterate through all elements
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
	HELP: ".indexOf" - https://www.w3schools.com/java/ref_string_indexof.asp
          https://www.youtube.com/watch?v=bl8ue-dTxgs&ab_channel=NickWhite
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {  // return largest common prefix between all strings in array... start at 1st character of first word and check remaining characters for remaining words

        if (strs.length == 0) {  // if array passed in contains no string element...
            return "";  // return empty string
        }

        String prefix = strs[0];  // comparison string... we compare first element's characters to characters of all other elements in string array

        for (int i=1; i<strs.length; i++) {  // iterate through all elements in the array... starting from index '1' because we already have index '0' (prefix variable)
            while(strs[i].indexOf(prefix) != 0) {  // while we cannot find prefix value i.e. 'flower' at the beginning of the next word i.e. 'flow', then...
                // remove last element of prefix string i.e. when comparing 'flower' to 'flow'... flower is not in flow
                // therefore... 'flower' becomes 'flowe' .... 'flower' becomes 'flow' (matches) so then we move to next element and compare 'flow' to 'flight'
                // and keep removing etc. this keeps decrementing until we find common elements for all strings in array
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;  // return the largest common string prefix found
    }
}