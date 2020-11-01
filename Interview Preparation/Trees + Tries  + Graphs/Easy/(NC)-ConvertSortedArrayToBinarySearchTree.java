/*
	Question: Given a sorted array, convert it to a height balanced ('depth of the two subtrees of every node never differ by more than 1') BST (binary search tree)
	Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	
    Time Complexity: O(n) - where 'n' is the number of elements in sorted input array
    Space Complexity: O(2n) -> O(n) (drop constants) - O(recursion depth) 'O(n)' as we will have 'n' total return statements before we reach a base case (all these returns are placed on the call stack)... also allocating memory of size 'n' to binary tree (storing all array elements as nodes)
*/

class Solution {
    public TreeNode sortedArrayToBST(int nums[]) {  
        if (nums.length == 0) { 
            return null;
        }
        return constructBSTRecursive(nums, 0, nums.length-1);  
    }

    private TreeNode constructBSTRecursive(int nums[], int left, int right) {
        if (left > right) {  
            return null; 
        }

        int mid = left + (right - left) / 2;  
        TreeNode current = new TreeNode(nums[mid]);  
        current.left = constructBSTRecursive(nums, left, mid - 1);  
        current.right = constructBSTRecursive(nums, mid + 1, right);  
        return current;
    }
}
