/*
	Question: If there is a duplicate character in string 's' remove the original and the duplicate... i.e. that character no longer appears in string
	Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

    Time Complexity: O(n) - where 'n' represents the size of the string as we iterate through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
*/

class Solution {
    public String removeDuplicates(String S) {  
        Stack<Character> stack = new Stack<Character>(); 

        for(int i=0; i<S.length(); i++) {

            if (stack.isEmpty()) { 
                stack.push(S.charAt(i)); 
            }

            else if (S.charAt(i)  == stack.peek()) {  
                stack.pop(); 
            }

            else {  
                stack.push(S.charAt(i));  
            }
        }
        Iterator value = stack.iterator();  
        StringBuilder sb = new StringBuilder();  

        while (value.hasNext()) {  
            sb.append(value.next()); 
        }
        return sb.toString();  
    }
}