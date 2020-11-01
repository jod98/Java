/*
	Question: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid if: 'Open brackets must be closed by the same type of brackets' AND 'Open brackets must be closed in the correct order'
	Problem: https://leetcode.com/problems/valid-parentheses/
    
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterare through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply a stack to store up-to 'n' characters
    HELP: https://www.youtube.com/watch?v=CCyEXcNamC4&ab_channel=BackToBackSWE
*/

class Solution {
    public boolean isValid(String s) {  // return true/false if we valid/invalid parentheses string

        Stack <Character> stack = new Stack <Character>();  // initialising a stack to hold all the left parentheses i.e. LIFO (Last In First Out) - so we most recent opening to next closing
        for (int i=0; i<s.length(); i++) {  // iterate through all characters in string 's'

            if (s.charAt(i) == '('  || s.charAt(i) == '{' || s.charAt(i) == '[') { // if we see a 'left opening bracket'.==
                stack.push(s.charAt(i));  // push onto the stack
            }
            else {
                if (stack.isEmpty()) {  // if there are no 'left opening brackets' left in stack to compare to current 'right opening bracket'... then it's not balanced
                    return false;
                }
                if (s.charAt(i) == ')' && stack.peek() != '(' ||
                        s.charAt(i) == '}' && stack.peek() != '{' ||
                        s.charAt(i) == ']' && stack.peek() != '[' ) {

                    return false;  // if current right 'type' parentheses does not equal most recent left 'type' parentheses (from stack - peek retrieves its value)... then it's not balanced
                }
                stack.pop();  // if current right parentheses = current left parentheses in stack then we remove ('pop') it from stack to access next element then compare again at next loop
            }
        }
        return stack.isEmpty();  // if this returns 'true' then all left parentheses have been matched with right parentheses... therefore balanced
    }
}