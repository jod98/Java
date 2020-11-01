/*
    Question: Write a function that reverses a string. The input string is given as an array of characters char[]. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	Problem: https://leetcode.com/problems/reverse-string/
	
    Time Complexity: O(n) - where 'n' represents the size of the char array as we iterate through all elements
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values... memory consumption not affected by input
*/

class Solution {
    public void reverseString(char[] s) {  // return the input character array reversed
        int curr = s.length-1;  // iterates through the array from back to front swapping the elements

        for (int i=0; i<s.length; i++) {  // iterate through all elements in the character array

            if (i >= curr) {  // if 'i' = 'curr'... then they are on the same element so no need to swap - (LENGTH ODD) OR if 'i' > 'curr' then both 'i' and 'curr' have overlapped so don't continue to swap - (LENGTH EVEN)
                break;  // break out of the loop
            }
            else {  // otherwise...
                char temp = s[curr];  // store last element in temp variable
                s[curr] = s[i];  // set last element = first element
                s[i] = temp;  // set first element = temp (last element)
                curr--;  // decrement 'curr' so we can access previous element in the list until there is no more to swap
            }
        }
    }
}