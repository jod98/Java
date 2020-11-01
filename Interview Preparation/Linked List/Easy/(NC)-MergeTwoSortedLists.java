/*
    Question: Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
	Problem: https://leetcode.com/problems/merge-two-sorted-lists/
	
    Time Complexity: O(n+m) - two different linked list sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 

        if (l1 == null && l2 == null) {  
            return null;  
        }
        if (l1 == null) { 
            return l2;  
        }
        if (l2 == null) {  
            return l1;  
        }
        ListNode dummy = new ListNode(0);  
        ListNode curr = dummy;  

        while (l1 != null && l2 != null) {  
            if (l1.val <= l2.val) {  
                curr.next = l1;  
                l1 = l1.next; 
            } else {
                curr.next = l2; 
                l2 = l2.next;  
            }
            curr = curr.next;  
        }
        if (l1 != null) {  
            curr.next = l1;  
        }
        if (l2 != null) {  
            curr.next = l2;  
        }
        return dummy.next;  
    }
}