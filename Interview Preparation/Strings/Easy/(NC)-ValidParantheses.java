/*
	Question: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid if: 'Open brackets must be closed by the same type of brackets' AND 'Open brackets must be closed in the correct order'
	Problem: https://leetcode.com/problems/valid-parentheses/
    
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterare through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply a stack to store up-to 'n' characters
*/

class Solution {
    public boolean isValid(String s) {  

        Stack <Character> stack = new Stack <Character>();  
        for (int i=0; i<s.length(); i++) { 

            if (s.charAt(i) == '('  || s.charAt(i) == '{' || s.charAt(i) == '[') { 
                stack.push(s.charAt(i)); 
            }
            else {
                if (stack.isEmpty()) { 
                    return false;
                }
                if (s.charAt(i) == ')' && stack.peek() != '(' ||
                        s.charAt(i) == '}' && stack.peek() != '{' ||
                        s.charAt(i) == ']' && stack.peek() != '[' ) {

                    return false;  
                }
                stack.pop();  
            }
        }
        return stack.isEmpty();  
    }
}