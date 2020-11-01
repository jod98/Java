/*
	Question: Write a program to find the node at which the intersection (common elements) of two singly linked lists begins
	Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
	
    Time Complexity: O(n+m) - two different linked list sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) { 
            return null;
        }

        ListNode p1 = headA;  
        ListNode p2 = headB; 

        while (p1 != p2) { 
            p1 = p1.next;  
            p2 = p2.next;  

            if (p1 == p2) {
                return p1;  
            }
            if (p1 == null) { 
                p1 = headB;  
            }
            if (p2 == null) { 
                p2 = headA;  
            }
        }
        return p1;  
    }
}

