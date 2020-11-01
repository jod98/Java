/*
	Question: Given a binary tree, check whether it is a mirror of itself (symmetric around its center) i.e. [1,2,2,3,4,4,3] is symmetric
	Problem: https://leetcode.com/problems/symmetric-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {  
        if (root == null) {  
            return true;
        }
        return isMirror(root.left, root.right);  
    }

    public boolean isMirror(TreeNode leftSubRoot, TreeNode rightSubRoot) {  
        if (leftSubRoot == null && rightSubRoot == null) {
            return true;
        }

        if (leftSubRoot != null && rightSubRoot != null) {
            return leftSubRoot.val == rightSubRoot.val &&  
                    isMirror(leftSubRoot.left, rightSubRoot.right) &&
                    isMirror(leftSubRoot.right, rightSubRoot.left);  
        }
        return false;
    }
}
