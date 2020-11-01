/*
	Question: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	Problem: https://leetcode.com/problems/valid-palindrome/
    
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterare through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly due to the fact we are initialising a string 'reversed' to store 'n' characters where 'n' represents length of input string 's'
*/

class Solution {
    public boolean isPalindrome(String s) {  // return true/false is String 's' is/not a palindrome

        boolean result = false;  // stores current boolean value (returned)
        s = s.replaceAll("[^a-zA-Z0-9]","");  // replacing all special characters (#/%^...) with ''
        String reversed = "";  // reversing current string and then comparing elements

        for (int i=s.length()-1; i>=0; i--) {  // iterate through input String 's' backwards and add the characters to the reversed string
            reversed += s.charAt(i);
        }

        if(s.equalsIgnoreCase(reversed)) {  // if the input string equals the reversed string (ignoring upper/lower case), then it has to be a palindrome
            result = true;  // return true
        }

        return result;  // return the result (this will return false if not a palindrome as false was initial value set to 'result')
    }
}