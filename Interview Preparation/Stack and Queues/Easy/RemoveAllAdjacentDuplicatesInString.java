/*
	Question: If there is a duplicate character in string 's' remove the original and the duplicate... i.e. that character no longer appears in string
	Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

    Time Complexity: O(n) - where 'n' represents the size of the string as we iterate through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
*/

class Solution {
    public String removeDuplicates(String S) {  // remove all characters in the string which have a duplicate
        Stack<Character> stack = new Stack<Character>();  // used to compare current string character again top of stack to determine if adjacent elements are equal... if so then pop off stack

        for(int i=0; i<S.length(); i++) {  // iterate through all characters in the String 'S'

            if (stack.isEmpty()) {  // if stack is not empty...
                stack.push(S.charAt(i));  // add current character to the stack
            }

            else if (S.charAt(i)  == stack.peek()) {  // if current character is string 'S' equals the character at the top of the stack i.e. the previous character...
                stack.pop();  // remove character from stack i.e. remove chars with have a duplicate
            }

            else {  // otherwise we simply just...
                stack.push(S.charAt(i));  // add current character to the stack
            }
        }
        Iterator value = stack.iterator();  // initialising an iterator to iterate through all elements (characters) in the stack
        StringBuilder sb = new StringBuilder();  // creating a StringBuilder (modifiable string) which stores all the characters in the stack

        while (value.hasNext()) {  // while we can retrieve the next value i.e. iterate through all elements in stack from bottom to top...
            sb.append(value.next()); // add characters/elements from stack to StringBuilder
        }

        return sb.toString();  // return format is 'String'... therefore converting StringBuilder to String
    }
}