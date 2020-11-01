/*
	Question: Return the sum of all the scores on the record where 'n' input array contains strings. "+" = record new score of previous 2 scores. "D" = record new score that is double of previous score. "C" = remove last score from record.
	Problem: https://leetcode.com/problems/baseball-game/
	
    Time Complexity: O(2n) -> O(n) (drop constants) - where 'n' represents the strings in input array 'ops' as we iterate over all them in 2 separate for loops
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
*/

class Solution {
    public int calPoints(String[] ops) {  // returning the sum of all records in the string array after its various operations
        Stack<Integer> stack = new Stack<Integer>();  // creating a stack to manipulate the contents of the record
        for (int i=0; i<ops.length; i++) {  // iterating through all elements in the string array

            if (ops[i].equals("+")) {  // if current element = '+', then we add the two previous scores (values)
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }

            else if (ops[i].equals("C")) {  // if current element = 'C', then we remove previous score
                stack.pop();
            }

            else if (ops[i].equals("D")) {  // if current element = 'D', then we 2 * previous score
                stack.push(2 * stack.peek());
            }

            else {
                stack.push(Integer.valueOf(ops[i]));  // otherwise current element is an 'int', so we just push it onto the stack
            }

        }
        int sum = 0;
        while(!stack.isEmpty()) {  // iterating through all integer values in the stack and while stack is not empty just 'pop' all the numbers off and sum them
            sum += stack.pop();
        }
        return sum;  // return sum of all the numbers in the stack
    }
}