/*
    Question: Once we find the right bracket that matches the left seperate this section (primitive decomposition)... then lastly after iterating over all characters in String 's' remove the outer brackets from your primitive decomposed sections
	Problem: https://leetcode.com/problems/remove-outermost-parentheses/
	
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterate through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
    HELP: https://www.youtube.com/watch?v=Evrdo1JEnmo&ab_channel=NideeshTerapalli
*/

class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>(); 
        ArrayList<Integer> arrayList = new ArrayList<Integer>();  

        for (int i=0; i<S.length(); i++) {

            if (stack.isEmpty()) {
                arrayList.add(i); 
            }
            if (S.charAt(i) == '(') {  
                stack.push(S.charAt(i)); 
            }
            if (S.charAt(i) == ')' && !stack.isEmpty()) {  
                stack.pop(); 

                if(stack.isEmpty()) {  
                    arrayList.add(i);  
                }
            }
        }

        StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<arrayList.size(); i+=2) {  overlap
            sb.append( S.substring( arrayList.get(i) + 1, arrayList.get(i + 1)));  
        }
        return sb.toString();
    }
}

