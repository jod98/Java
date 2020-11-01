/*
	Question: Given a binary tree, check whether it is a mirror of itself (symmetric around its center) i.e. [1,2,2,3,4,4,3] is symmetric
	Problem: https://leetcode.com/problems/symmetric-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
    HELP: https://www.youtube.com/watch?v=XV7Sg2hJO3Q&ab_channel=BackToBackSWE
          https://www.youtube.com/watch?v=3iIpnouY-bg&ab_channel=TerribleWhiteboard
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {  // return true/false if tree is symmetric (left subtree is mirror of right subtree) - "fold over"
        if (root == null) {  // if root = null... then we have no more nodes in tree therefore has to be symmetric
            return true;
        }
        return isMirror(root.left, root.right);  // call the function below which checks if left subtree and right subtree are symmetrical... passing in first node of left subtree and first node of right subtree

    }

    public boolean isMirror(TreeNode leftSubRoot, TreeNode rightSubRoot) {  // function that returns if left subtree is a mirror/symmetric to right subtree
        /* if both nodes (initially root nodes) are null then we cannot have right or left child, therefore they have to be symmetrical subtrees...
           we keep going checking tree's children until they both are null then we know they are same */

        if (leftSubRoot == null && rightSubRoot == null) {
            return true;
        }

         /*
        Recursively call the (left subtree's left child, right subtree's right child) AND (left subtree's right child, right subtree's left child) and compare values to determine
        if the subtrees are symmetric. '(leftSubRoot.left, rightSubRoot.right)' will be called until we hit a base case i.e. retrieve a value then we will work our way up the tree passing
        the value to root node which will then allows us to the check the next recursive call. Then we return the answer '&&' i.e. if True && True return true... otherwise return false
        */

        if (leftSubRoot != null && rightSubRoot != null) {
            return leftSubRoot.val == rightSubRoot.val &&  // returns true/false is both values are/not same
                    isMirror(leftSubRoot.left, rightSubRoot.right) &&  // recursive call
                    isMirror(leftSubRoot.right, rightSubRoot.left);  // recursive call
        }

        return false;  // otherwise their values aren't the same so return false

    }
}
