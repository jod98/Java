/*
	Question: Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
	Problem: https://leetcode.com/problems/delete-node-in-a-linked-list/

    Time Complexity: O(1) - constant time as we are just performing insertion and deletion operation on linked list which is O(1)
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables (two pointers) to store values... memory consumption not affected by input
*/

class Solution {
    public void deleteNode(ListNode node) {  
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}