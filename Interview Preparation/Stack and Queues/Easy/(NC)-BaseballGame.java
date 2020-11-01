/*
	Question: Return the sum of all the scores on the record where 'n' input array contains strings. "+" = record new score of previous 2 scores. "D" = record new score that is double of previous score. "C" = remove last score from record.
	Problem: https://leetcode.com/problems/baseball-game/
	
    Time Complexity: O(2n) -> O(n) (drop constants) - where 'n' represents the strings in input array 'ops' as we iterate over all them in 2 separate for loops
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
*/

class Solution {
    public int calPoints(String[] ops) {  
        Stack<Integer> stack = new Stack<Integer>();  
        for (int i=0; i<ops.length; i++) { 

            if (ops[i].equals("+")) {  
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }

            else if (ops[i].equals("C")) {
                stack.pop();
            }

            else if (ops[i].equals("D")) {  
                stack.push(2 * stack.peek());
            }

            else {
                stack.push(Integer.valueOf(ops[i]));  
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) { m
            sum += stack.pop();
        }
        return sum; 
    }
}