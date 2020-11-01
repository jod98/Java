/*
	Question: Check if BST 't' is a subtree of BST 's'. N.B. A subtree of s is a tree consists of a node in 's' and all of this node's descendants
	Problem: https://leetcode.com/problems/subtree-of-another-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) - 2 branch for each node -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
    HELP: https://www.youtube.com/watch?v=HdMs2Fl_I-Q&ab_channel=KevinNaughtonJr.
*/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {  // return true/false if tree 't' is/not in tree 's' i.e. is a subtree of

        if (s == null) {  // checking if 's' (larger tree) is null because 't' cannot be a subtree of 'null'
            return false;  // therefore 't' is not a subtree so return null
        }

        else if (isSameTree(s, t)) {  // if they are the exact same tree then 't' is technically a subset of 's' so...
            return true;
        }

        else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);  // otherwise retrieve left subtree and right subtree of 's' and compare them against 't'.... recursive call
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {  // function used to determine if the 't' is a subtree of 's'
        if (s == null || t == null) {  // if either tree = null then...
            return s == null && t == null;  // we return boolean (true or false) to determine if both are null... both need to be null if 't' is to be a subtree of 's'
        }

        else if (s.val == t.val) {  // if the values of the current node match then...
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);  // retrieve the left child and right child of both 's' and 't' and then compare
        }

        else {  // otherwise... they 't' is not a subtree of 's'
            return false;
        }
    }
}

