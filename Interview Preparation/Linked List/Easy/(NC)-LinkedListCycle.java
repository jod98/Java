/*
    Question: Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Return true if there is a cycle in the linked list. Otherwise, return false.
	Problem: https://leetcode.com/problems/linked-list-cycle/
	
    Time Complexity: O(n) - where 'n' represents number of links in the input linked list 'head'. We iterate through all links to determine if there is a cycle
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

public class Solution {
    public boolean hasCycle(ListNode head) {  
        ListNode fastPointer = head;  
        ListNode slowPointer = head; 

        while(fastPointer != null && fastPointer.next != null) {  
            fastPointer = fastPointer.next.next;  
            slowPointer = slowPointer.next;  

            if (fastPointer == slowPointer) { 
                return true;
            }
        }
        return false;
    }
}