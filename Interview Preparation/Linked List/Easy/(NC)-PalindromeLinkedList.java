/*
    Question: Given a singly linked list, determine if it is a palindrome.
	Problem: https://leetcode.com/problems/palindrome-linked-list/
	
    Time Complexity: O(n) - where 'n' represents number of links in the input linked list 'head'. We iterate through all links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables (two pointers) to store values... memory consumption not affected by input
*/

class Solution {
    public boolean isPalindrome(ListNode head) { 
        ListNode fastPointer = head; 
        ListNode slowPointer = head; 

        while (fastPointer != null && fastPointer.next != null) {  
            fastPointer = fastPointer.next.next;  
            slowPointer = slowPointer.next; 
        }

        fastPointer = head;  
        slowPointer = reverse(slowPointer);  
        while(slowPointer != null) {  
            if (slowPointer.val != fastPointer.val) {  
                return false;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {  
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