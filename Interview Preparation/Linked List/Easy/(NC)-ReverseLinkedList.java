/*
	Question: Reverse a singly linked list.
	Problem: https://leetcode.com/problems/reverse-linked-list/
	
    Time Complexity: O(n) - where 'n' represents number of links in the input linked list 'head'. We iterate through all links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables (two pointers) to store values... memory consumption not affected by input
*/

class Solution {
    public ListNode reverseList(ListNode head) {  
        ListNode prev = null;  
        ListNode curr = head;  
        ListNode next = null;  

        while(curr != null) {  
            next = curr.next;  
            curr.next = prev;  
            prev = curr;  
            curr = next; 
        }
        return prev;  
    }
}