/*
	Question: Write a function to check if two binary trees 'p' and 'q' are the same. They must have be structually identical and nodes must have same values.
	Problem: https://leetcode.com/problems/same-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {  
        if (p == null && q == null) { 
            return true;
        }

        if (p != null && q != null) {
            return p.val == q.val &&  
                    isSameTree(p.left, q.left) &&   
                    isSameTree(p.right, q.right); 
        }
        return false;  
    }
}