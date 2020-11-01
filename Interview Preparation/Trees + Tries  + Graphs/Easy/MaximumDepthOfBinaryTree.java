/*
    Question: Given a binary tree, find its maximum depth (number of nodes along the longest path from the root node down to the farthest leaf node)
	Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
    HELP: https://www.youtube.com/watch?v=YT1994beXn0&ab_channel=StephenO%27Neill
          https://www.youtube.com/watch?v=D2cFSDfg0So&t=329s&ab_channel=KevinNaughtonJr.
*/

class Solution {
    public int maxDepth(TreeNode root) {  // return maximum depth of tree (number of levels in tree)

        if (root == null) {  // base case
            return 0;
        }

        /* calculate current depth of left child until we hit null... once we hit null we return 0 and then 'int left = 0' so we then move back up one from null node and then calculate right child... after we hit null for both right and left child, both 'left' and 'right' = 0 meaning we are at the last nodes in the left subtree. We then execute last statement which returns depth of '1'... this then recursively continues all the way back up the tree until we keep adding the depth each time. Finally we compare the left subtree and right subtree depth and return the max (i.e. subtree with greatest depth = tree depth)

         */

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;  // adding '1' to indicate depth
    }
}

