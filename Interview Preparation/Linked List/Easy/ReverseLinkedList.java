/*
	Question: Reverse a singly linked list.
	Problem: https://leetcode.com/problems/reverse-linked-list/
	
    Time Complexity: O(n) - where 'n' represents number of links in the input linked list 'head'. We iterate through all links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables (two pointers) to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=O0By4Zq0OFc&ab_channel=BackToBackSWE
*/

class Solution {
    public ListNode reverseList(ListNode head) {  // return the linked list reversed
        ListNode prev = null;  // pointer 'prev' = null (stored at element before head i.e. null) - null,1,2,3,4,null
        ListNode curr = head;  // pointer 'curr' = head (first element in linked list)
        ListNode next = null;  // pointer 'next' = null (stored at element before head i.e. null) - null,1,2,3,4,null

        while(curr != null) {  // while 'curr' node != null i.e. we haven't reached last node in list
            next = curr.next;  // 'next' equals node after current
            curr.next = prev;  // 'curr.next' now points backwards to previous node
            prev = curr;  // 'prev' is now assigned to current node
            curr = next;  // 'curr' node incremented by one i.e. it points to next node in list
        }
        return prev;  // return the reverse linked list - 'prev' is now last element in linked list and becomes new head as arrows between links are backwards
    }
}