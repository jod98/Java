/*
	Question: Invert a binary tree
	Problem: https://leetcode.com/problems/invert-binary-tree/

    Time Complexity: O(n) - where 'n' represents number of nodes in the tree... we traverse through all nodes once
    Space Complexity: O(n) - function calls will be placed on the stack due to recursive calls
*/

class Solution {
    public TreeNode invertTree(TreeNode root) { 
        if (root == null) {  
            return null;
        }

        TreeNode right = invertTree(root.right); 
        TreeNode left = invertTree(root.left); 

        root.left = right;  
        root.right = left;

        return root;  
    }
}