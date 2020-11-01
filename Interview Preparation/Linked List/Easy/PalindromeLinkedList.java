/*
    Question: Given a singly linked list, determine if it is a palindrome.
	Problem: https://leetcode.com/problems/palindrome-linked-list/
	
    Time Complexity: O(n) - where 'n' represents number of links in the input linked list 'head'. We iterate through all links
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables (two pointers) to store values... memory consumption not affected by input
    HELP: https://www.youtube.com/watch?v=vHam6riSavo&ab_channel=TerribleWhiteboard
*/

class Solution {
    public boolean isPalindrome(ListNode head) {  // return true/false if linked list is/not palindrome
        ListNode fastPointer = head;  // traverse list 2 steps at a time
        ListNode slowPointer = head;  // traverse list 1 step at a time

        while (fastPointer != null && fastPointer.next != null) {  // while fastPointer != null and next element != null i.e we have to have at least 1 element (not palindrome if 1 element)
            fastPointer = fastPointer.next.next;  // update fastPointer '2' steps
            slowPointer = slowPointer.next;  // update slowPointer '1' step
        }

        fastPointer = head;  // reset 'fastPointer' to point at head of linked list
        slowPointer = reverse(slowPointer);  // reversing second half of linked list (slowPointer current at midpoint of list)
        while(slowPointer != null) {  // choosing 'slowPointer' because it increments one at a time
            if (slowPointer.val != fastPointer.val) {  // now comparing the two linked lists... (1) - first half in order, (2) - second half reversed
                // if not equal then not a palindrome... this method works with odd linked list length as when we hit 'null' when we traverse 'slowPointer',
                // we know that all the elements before previously matched 'fastPointer' therefore the last element of 'fastPointer' could be any number and it does not matter
                //i.e. 'head' (linked list) = 1->2->2->2->1
                //i.e. 'fastPointer' = 1->2->2->null
                //i.e. 'slowPointer' = 1->2->null
                return false;
            }

            slowPointer = slowPointer.next;  // update 'slowPointer' '1' step and compare
            fastPointer = fastPointer.next;  // update 'fastPointer' '1' step and compare
        }
        return true;  // therefore we have a palindrome linked list
    }

    public ListNode reverse(ListNode head) {  // return the linked list reversed
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