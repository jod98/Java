/*
	Question: Check if BST 't' is a subtree of BST 's'. N.B. A subtree of s is a tree consists of a node in 's' and all of this node's descendants
	Problem: https://leetcode.com/problems/subtree-of-another-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) - 2 branch for each node -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
*/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {  

        if (s == null) { 
            return false;
        }

        else if (isSameTree(s, t)) {  
            return true;
        }

        else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);  
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t) { 
        if (s == null || t == null) {  
            return s == null && t == null;  
        }

        else if (s.val == t.val) { 
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }

        else {
            return false;
        }
    }
}

