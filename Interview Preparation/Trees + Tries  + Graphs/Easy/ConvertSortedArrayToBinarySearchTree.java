/*
	Question: Given a sorted array, convert it to a height balanced ('depth of the two subtrees of every node never differ by more than 1') BST (binary search tree)
	Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	
    Time Complexity: O(n) - where 'n' is the number of elements in sorted input array
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)... also allocating memory of size 'n' to binary tree (storing all array elements as nodes)
    HELP: https://www.youtube.com/watch?v=PZYTs9y4f4o&ab_channel=KevinNaughtonJr.
*/

class Solution {
    public TreeNode sortedArrayToBST(int nums[]) {  // create and return a binary tree from the sorted array of elements
        // Binary Search Tree (BST) = think recursively
        if (nums.length == 0) {  // if there are no elements in the array...
            return null;  // return null
        }

        return constructBSTRecursive(nums, 0, nums.length-1);  // calling private function (means it cannot be accessed outside this class i.e. it won't interfere with another program with same function alias)... passing in the sorted array, leftmost index and rightmost index (so we can traverse entire array from inwards to outwards)
    }

    private TreeNode constructBSTRecursive(int nums[], int left, int right) {  // returns the BST construction of the sorted array
        if (left > right) {  // if left index overtakes right index then we have traversed every element in the array i.e. overlap so...
            return null;  // return null
        }

        int mid = left + (right - left) / 2;  // retrieve the middle element in the array (if even length array then it is the 'middle left' number because there will be 2 middle numbers technically)
        TreeNode current = new TreeNode(nums[mid]);  // add the middle element in the array to the tree (as the root node)... over recursive iterations this will current node we on as we traverse through left and right children
        current.left = constructBSTRecursive(nums, left, mid - 1);  // traverse from middle element to front of array retrieving each element... we then call this private function with the element we want to add and when we reach the line above this element will be added as a node in the tree. All the left children added until we reach 'null' then we traverse back up level by level adding right child until we eventually complete the right subtree and rebegin from the root node
        current.right = constructBSTRecursive(nums, mid + 1, right);  // traverse from middle element to back of array... we then call this private function with the element we want to add and when we reach the line above this element will be added as a node in the tree. All the right children added until we reach 'null' then we traverse back up level by level adding left child until we eventually complete the left subtree and rebegin from the root node
        return current;  // tree is completely made up after we traverse all element in array therefore... just return 'current' (BST)
    }
}
