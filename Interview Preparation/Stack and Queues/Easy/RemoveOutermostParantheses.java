/*
    Question: Once we find the right bracket that matches the left seperate this section (primitive decomposition)... then lastly after iterating over all characters in String 's' remove the outer brackets from your primitive decomposed sections
	Problem: https://leetcode.com/problems/remove-outermost-parentheses/
	
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterate through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
    HELP: https://www.youtube.com/watch?v=Evrdo1JEnmo&ab_channel=NideeshTerapalli
*/

class Solution {
    public String removeOuterParentheses(String S) {  // removing outside parenthesis from each primitive decomposition i.e. once opening character matches closing character... then that's 1 section (decomposition)
        Stack<Character> stack = new Stack<Character>();  // pushing opening brackets onto stack and popping them off there is a closing bracket
        ArrayList<Integer> arrayList = new ArrayList<Integer>();  // stores the index for where each decomposition starts and ends so we can locate and remove the outer parenthesis

        for (int i=0; i<S.length(); i++) {  // iterating over all characters in the string 'S'

            if (stack.isEmpty()) {  // if stack is empty...
                arrayList.add(i);  // add current index to arrayList (start of decomposition)
            }
            if (S.charAt(i) == '(') {  // if current char is an opening bracket then...
                stack.push(S.charAt(i));  // push opening bracket onto stack
            }
            if (S.charAt(i) == ')' && !stack.isEmpty()) {  // if current char is closing bracket AND stack is not empty then...
                stack.pop();  // remove current element from stack i.e. the matching opening bracket

                if(stack.isEmpty()) {  // if we've iterate through all characters in string and when we remove the element from the stack and its becomes empty then...
                    arrayList.add(i);  // add current index to arrayList (end of decomposition)
                }
            }
        }

        StringBuilder sb = new StringBuilder(); // creating modifiable string to store the input with the outer parentheses removed
        for (int i=0; i<arrayList.size(); i+=2) {  // iterate through all indexes (elements) in the arrayList in increments of '2' as we want to check... 2 elements, next 2 elements etc.. we don't want overlap
            sb.append( S.substring( arrayList.get(i) + 1, arrayList.get(i + 1)));  // append section of string with outer parentheses removed i.e. arrayList = <0,5,6,9>, sb.append(arrayList.get(0)+1, arrayList.get(5))... therefore we retrieve everything between index 1-4. Index 0 and 5 are the outer parantheses
        }

        return sb.toString();  // return the result converted back to a string ('String' is the return type)
    }
}

