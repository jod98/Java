/*
	Question: Given two arrays, write a function to compute their intersection. Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.
	Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
    
    Time Complexity: O(n+m) - two different array sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' elements
    Space Complexity: O(n+m) - consumption of memory scales linearly with input as we store up-to 'n' and 'm' elements in the newly created array
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) { 
        int commonElements[] = new int [nums1.length * nums2.length]; /
        int i = 0, j = 0, x = 0; 

        Arrays.sort(nums1);
        Arrays.sort(nums2); 

        while (i < nums1.length && j < nums2.length) { 
            if (nums1[i] < nums2[j]) { 
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                commonElements[x++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(commonElements, 0, x); 
    }
}