/*
	Question: Given two strings s and t , write a function to determine if t is an anagram of s.
	Problem: https://leetcode.com/problems/valid-anagram/
    
    Time Complexity: O(nlogn) - where 'n' is the length of String 's', sorting costs O(nlog n) - (quick sort) and comparing two strings costs O(n). Sorting time dominates and the overall time complexity is O(nlog n)
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise char arrays 'n' characters where 'n' represents number of chars in String 's' and 't'
*/

class Solution {
    public boolean isAnagram(String s, String t) {  // return true/false if strings are/not equal

        if (s.length() != t.length()) {  // if lengths of string not equal then their contents can't be equal
            return false;
        }

        char str1[] = s.toCharArray();  // store 's' in a character array
        char str2[] = t.toCharArray();  // store 't' in a character array

        Arrays.sort(str1);  // sort 'str1' i.e. in alphabetical order
        Arrays.sort(str2);  // sort 'str2' i.e. in alphabetical order

        return Arrays.equals(str1, str2);  // compare the two char array and if they equal this will return true, else return false
    }
}