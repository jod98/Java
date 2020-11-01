/*
	Question: Find the next greatest element in nums2 from the right of the current element in nums1

	Example: nums1 = [4,1,2], nums2 = [1,3,4,2]...
	-> '4'? Is there a number greater than 4 from the right of '4' in nums2... NO (return -1)
	-> '1'? Is there a number greater than 1 from the right of '1' in nums2... YES (return 3) - first greater
	-> '2'? Is there a number greater than 2 from the right of '2' in nums2... NO (return -1)
	
	Problem: https://leetcode.com/problems/next-greater-element-i/
    
    Time Complexity: O(n + m) - we iterate over every character in nums1 and nums2 where 'n' and 'm' represents number of elements in array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
    HELP: https://www.youtube.com/watch?v=8BDKB2yuGyg&ab_channel=NickWhite
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {  // return array with next greatest elements from righthand side of value in nums2
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  // hashmap will store current element in nums2 and it's next greatest value
        Stack<Integer> stack = new Stack<Integer>();  // stock will push next greatest element on at a time... used a lookup to compare current element and find next greatest element

        for (int num : nums2) {  // iterate through all elements in nums2

            while (!stack.isEmpty() && stack.peek() < num) {  // while stack is not empty and current stack value is less than current array element.. then we found our next greatest number... while loop used so we don't keep adding elements to stack in search for next greatest...
                map.put(stack.pop(), num);  // add current stack element and its next greatest value into hashmap for lookup later
            }
            stack.push(num);  // we have popped of the most recent element which had a value greater to its right handside... now we add this righthand side element to stack and find its next greatest value
        }

        for (int i=0; i<nums1.length; i++) {  // iterate through all elements in nums1 and use hashmap to lookup
            nums1[i] = map.getOrDefault(nums1[i], -1);  // if current element in nums1 has a 'key' that is in the hashmap then retrieve its 'value' (next greates element) and add thaat value to array... otherwise just input '-1'
        }

        return nums1;  // return the updated array
    }
}