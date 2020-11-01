/*
	Question: Write a function to check if two binary trees 'p' and 'q' are the same. They must have be structually identical and nodes must have same values.
	Problem: https://leetcode.com/problems/same-tree/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)
    HELP: https://www.youtube.com/watch?v=G9wwY-cmuiE&feature=youtu.be&ab_channel=TerribleWhiteboard
          https://www.youtube.com/watch?v=ySDDslG8wws&ab_channel=TusharRoy-CodingMadeSimple
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {  // 'p' and 'q' are the root node of two different binary tress. We return true/false is both trees are/not structurally identical
        if (p == null && q == null) {  // if both nodes (iniitally root nodes) are null then we cannot have right or left child, therefore they have to be structurally identical... we keep going checking tree's children until they both are null then we know they are same
            return true;
        }

        /*
        1. We access the recursive calls below if both nodes in both trees have a certain value
        2. We use recursion to call upon the leftmost child continuously until we reach null (pending they have same value all the way)
        3. Once both trees have hit null at same time and node values are same (return true) which means we move up one from 'null' node to previous node and check its rightmost child
        4. This recursively continues until we cover all left and right children in left subtree
        5. We then return to node value of both trees and recursively check right subtree
        6. This continues again until we reach null which means left subtree of both trees are identical and then ... 'isSameTree(p.left, q.left) = True' for the root node so we then check its right subtree
        7. '&&' means that both conditions need to be 'True' to make condition 'True'

        Note: Everytime we receive a true value (reached the null node for each subtree)... this value is then saved and we work our way back up the tree (recursion) telling the node that
              "yeah right subtree of both trees are equal"... then we check right subtree...
        */

        if (p != null && q != null) {
            return p.val == q.val &&  // returns true/false is both values are/not same
                    isSameTree(p.left, q.left) &&   // recursive call
                    isSameTree(p.right, q.right);  // recursive call
        }

        return false;  // otherwise their values aren't the same so return false
    }
}