/*
	Question: Find the next greatest element in nums2 from the right of the current element in nums1

	Example: nums1 = [4,1,2], nums2 = [1,3,4,2]...
	-> '4'? Is there a number greater than 4 from the right of '4' in nums2... NO (return -1)
	-> '1'? Is there a number greater than 1 from the right of '1' in nums2... YES (return 3) - first greater
	-> '2'? Is there a number greater than 2 from the right of '2' in nums2... NO (return -1)
	
	Problem: https://leetcode.com/problems/next-greater-element-i/
    
    Time Complexity: O(n + m) - we iterate over every character in nums1 and nums2 where 'n' and 'm' represents number of elements in array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise a stack to store up-to 'n' characters
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        Stack<Integer> stack = new Stack<Integer>();  

        for (int num : nums2) { 

            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);  
            }
            stack.push(num);  
        }

        for (int i=0; i<nums1.length; i++) {  
            nums1[i] = map.getOrDefault(nums1[i], -1); 
        }
        return nums1;  
    }
}