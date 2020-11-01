/*
	Question: Given a binary tree, return the 'bottom-up level order' traversal of its nodes (i.e. from to left ro right, level by level)
	Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(n) - consumption of memory scales linearly with input 'n' where 'n' represents number of nodes in binary tree. We allocate memory to list of lists which stores 'n' nodes
*/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();  // create an arraylist of arraylists... the inner arraylist will store all nodes at current level... these nodes will then be add to our arraylist and returned
        if (root == null) {  // if root of tree = null... then there are no more nodes in the tree so return empty list of lists
            return result;
        }

        // Breath First Search = Queue (Attempting to retrieve every node at level 1, 2, 3 etc.)
        // Depth First Seatch = Stack (Attempting to dive deep until we hit null and then level 'n' and slowly come back up and search next path)

        Queue<TreeNode> queue = new LinkedList<>();  // this is how queue is initialised (through linked list)... using this data structure to store all the nodes on the current level which will then be added to arraylist of arraylists ('result')
        queue.add(root);  // add root to queue (always the first node to traverse)

        while (!queue.isEmpty()) {  // while queue is not empty
            int size = queue.size();  // retrieve number of nodes in current tree level
            List<Integer> currentLevel = new ArrayList<>();  // creating an arraylist to store all nodes in current tree level

            for (int i=0; i<size; i++) {  // iterate through all nodes in the queue
                TreeNode current = queue.remove(); // we want to retrieve the current node (first node in queue - FIFO) that we need to process... then check it's left and right child etc.
                currentLevel.add(current.val);  // adding current node's value to the inner arraylist (current level)

                if (current.left != null) {  // if current node in level has a left child...
                    queue.add(current.left);  // add the left child to the end of the queue (to be processed later)
                }

                if (current.right != null) {  // if current node in level has a right child...
                    queue.add(current.right);  // add the left child to the end of the queue (to be processed later)
                }
            }
            result.add(currentLevel);  // add all nodes in current tree level to outer arraylist
        }
        Collections.reverse(result);  // reversing the list's order so it goes from 'bottom-up' not 'top-down'
        return result;  // return outer arraylist i.e. the list of the list of nodes in the tree (level by level)
    }
}
