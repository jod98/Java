/*
	Question: Given two strings s and t , write a function to determine if t is an anagram of s.
	Problem: https://leetcode.com/problems/valid-anagram/
    
    Time Complexity: O(nlogn) - where 'n' is the length of String 's', sorting costs O(nlog n) - (quick sort) and comparing two strings costs O(n). Sorting time dominates and the overall time complexity is O(nlog n)
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise char arrays 'n' characters where 'n' represents number of chars in String 's' and 't'
*/

class Solution {
    public boolean isAnagram(String s, String t) {  

        if (s.length() != t.length()) {  
            return false;
        }

        char str1[] = s.toCharArray();  
        char str2[] = t.toCharArray(); 

        Arrays.sort(str1);  
        Arrays.sort(str2);  

        return Arrays.equals(str1, str2);  
    }
}