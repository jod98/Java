/*
	Question: Invert a binary tree
	Problem: https://leetcode.com/problems/invert-binary-tree/

    Time Complexity: O(n) - where 'n' represents number of nodes in the tree... we traverse through all nodes once
    Space Complexity: O(n) - function calls will be placed on the stack due to recursive calls
    HELP: https://www.youtube.com/watch?v=fKgZiCXb6zs&ab_channel=NickWhite
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {  // return the binary tree inverted
        if (root == null) {  // if root of tree = null... then there are no more nodes in the tree
            return null;
        }

        TreeNode right = invertTree(root.right);  // retrieve right child of current node
        TreeNode left = invertTree(root.left);  // retrieve left child of current node

        root.left = right;  // left child = right child (swap)
        root.right = left;  // right child = left child (swap)

        return root;  // after all iterations i.e. traversed every node in tree... we just return the tree ('root' now contains all nodes of tree)
    }
}