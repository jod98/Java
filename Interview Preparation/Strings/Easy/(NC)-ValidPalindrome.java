/*
	Question: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	Problem: https://leetcode.com/problems/valid-palindrome/
    
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterare through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly due to the fact we are initialising a string 'reversed' to store 'n' characters where 'n' represents length of input string 's'
*/

class Solution {
    public boolean isPalindrome(String s) { 

        boolean result = false;  
        s = s.replaceAll("[^a-zA-Z0-9]","");  
        String reversed = "";  

        for (int i=s.length()-1; i>=0; i--) { 
            reversed += s.charAt(i);
        }

        if(s.equalsIgnoreCase(reversed)) {  
            result = true; 
        }

        return result;  
    }
}