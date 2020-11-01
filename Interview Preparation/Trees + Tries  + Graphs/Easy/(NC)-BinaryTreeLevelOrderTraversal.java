/*
	Question: Given a binary tree, return the 'level order' traversal of its nodes (i.e. from to left ro right, level by level)
	Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
	
    Time Complexity: O(n) - where 'n' is the number of nodes in binary tree... we visit each node once
    Space Complexity: O(n) - consumption of memory scales linearly with input 'n' where 'n' represents number of nodes in binary tree. We allocate memory to list of lists which stores 'n' nodes
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {  
        List<List<Integer>> result = new ArrayList<>();  
        if (root == null) {  
            return result;
        }

        // Breath First Search = Queue (Attempting to retrieve every node at level 1, 2, 3 etc.)
        // Depth First Seatch = Stack (Attempting to dive deep until we hit null and then level 'n' and slowly come back up and search next path)

        Queue<TreeNode> queue = new LinkedList<>();  /
        queue.add(root);  

        while (!queue.isEmpty()) {  
            int size = queue.size(); 
            List<Integer> currentLevel = new ArrayList<>();  

            for (int i=0; i<size; i++) {  
                TreeNode current = queue.remove(); 
                currentLevel.add(current.val);  

                if (current.left != null) {  
                    queue.add(current.left);  
                }

                if (current.right != null) {  
                    queue.add(current.right); 
                }
            }
            result.add(currentLevel);  
        }
        return result;
    }
}


