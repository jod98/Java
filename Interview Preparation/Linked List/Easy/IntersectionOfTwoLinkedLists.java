/*
	Question: Write a program to find the node at which the intersection (common elements) of two singly linked lists begins
	Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
	
    Time Complexity: O(n+m) - two different linked list sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=c7dOI-hDa2Q&ab_channel=TerribleWhiteboard
*/

public class Solution {
    // return the intersection node between two linked lists... difficult when both linked lists are of different lengths.. cannot do element by element comparison
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) { // if either linked list = null...
            return null; // return 'null'
        }

        ListNode p1 = headA;  // pointer 'p1' starts at head of 'headA' linked list
        ListNode p2 = headB;  // pointer 'p2' starts at head of 'headB' linked list

        while (p1 != p2) { // while 'p1' node != 'p2' node
            p1 = p1.next;  // increment 'p1' by 1 (to next node in list)
            p2 = p2.next;  // increment 'p2' by 1 (to next node in list)

            // if 'p1' ever equals 'p2' return either 'p1' or 'p2'... both pointers reference same intersection node...
            // but also to note: if both are 'null' at some point we just return null (loop doesn't continue forever in case where there is no intersection)
            if (p1 == p2) {
                return p1;  // return 'p1' or 'p2' - same intersection node
            }
            if (p1 == null) { // if 'p1' only = null...
                p1 = headB;  // reset 'p1' to headB (head of 1st linked list)
            }
            if (p2 == null) {  // if 'p2' only = null...
                p2 = headA;  // reset 'p2' to headB (head of 2nd linked list)
            }
        }
        return p1;  // return 'p1' (or 'p2' - both intersection node) at end... point in which 'p1' equals 'p2' because we break out of while loop
    }
}

