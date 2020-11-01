/*
    Question: Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
	Problem: https://leetcode.com/problems/merge-two-sorted-lists/
	
    Time Complexity: O(n+m) - two different linked list sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=GfRQvf7MB3k&ab_channel=BackToBackSWE
          https://www.youtube.com/watch?v=orCMI6WjoIw&ab_channel=TerribleWhiteboard
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // return a linked list with the combination of two sorted linked lists 

        if (l1 == null && l2 == null) {  // if pointer 'l1' and 'l2' i.e. the two linked lists are null...
            return null;  // return 'null'
        }
        if (l1 == null) {  // if pointer 'l1' (linked list 1) is null...
            return l2;  // returm linked list 2
        }
        if (l2 == null) {  // if pointer 'l2' (linked list 2) is null...
            return l1;  // return linked list 1
        }
        ListNode dummy = new ListNode(0);  // create a variable ('dummy') that will initialise the first link in the new linked list so we can continuously add links
        ListNode curr = dummy;  // setting variable 'current' to head of new linked list 

        while (l1 != null && l2 != null) {  // while both linked lists have elements
            if (l1.val <= l2.val) {  // if 'l1' (head pointer of linked list 1) <= 'l2' (head pointer of linked list 2)...
                curr.next = l1;  // add 'l1' (smaller element) to new linked list
                l1 = l1.next;  // now point to the next element in linked list 1
            } else {
                curr.next = l2;  // add 'l2' (smaller element) to new linked list
                l2 = l2.next;  // now point to the next element in linked list 2
            }
            curr = curr.next;  // update 'curr' so it points to next link in new linked list i.e. where the new value will be placed
        }
        if (l1 != null) {  // if we've reached the end of linked list 2... 
            curr.next = l1;  // next elements to add are rest of linked list 1
        }
        if (l2 != null) {  // if we've reached the end of linked list 1... 
            curr.next = l2;  // next elements to add are rest of linked list 2
        }
        return dummy.next;  // return the new linked list (combination of two sorted linked list 1 and 2)
    }
}