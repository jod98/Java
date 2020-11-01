/*
    Question: Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Return true if there is a cycle in the linked list. Otherwise, return false.
	Problem: https://leetcode.com/problems/linked-list-cycle/
	
    Time Complexity: O(n) - where 'n' represents number of links in the input linked list 'head'. We iterate through all links to determine if there is a cycle
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

public class Solution {
    public boolean hasCycle(ListNode head) {  // return true if there is a cycle in the list... if element reappears. 'head' represents entire linked list
        ListNode fastPointer = head;  // traverse list 2 steps at a time
        ListNode slowPointer = head;  // traverse list 1 step at a time

        while(fastPointer != null && fastPointer.next != null) {  // while fastPointer is not null and the next element is not null i.e we have to have at least 1 element... 1 element alone can never have a cycle
            fastPointer = fastPointer.next.next;  // update fastPointer '2' steps
            slowPointer = slowPointer.next;  // update slowPointer '1' step

            if (fastPointer == slowPointer) {  // if the two pointers ever equal same node i.e. same value and position then there has to be a cycle
                return true;
            }
        }
        return false; // otherwise there is no cycle and we have reached the end of the linked list
    }
}