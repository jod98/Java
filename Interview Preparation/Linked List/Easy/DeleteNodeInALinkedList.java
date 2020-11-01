/*
	Question: Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
	Problem: https://leetcode.com/problems/delete-node-in-a-linked-list/

    Time Complexity: O(1) - constant time as we are just performing insertion and deletion operation on linked list which is O(1)
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables (two pointers) to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=vHam6riSavo&ab_channel=TerribleWhiteboard
*/

class Solution {
    public void deleteNode(ListNode node) {  // deleting current node in linked list
        // we have to reassign current node's value to equal next node's value because we don't have access to previous element which will then link to the next element after node
        node.val = node.next.val;
        // we then set next element after node to next.next element i.e. we are removing the node after the one we want to delete (unable to delete current node) - sequence remains same
        node.next = node.next.next;
    }
}