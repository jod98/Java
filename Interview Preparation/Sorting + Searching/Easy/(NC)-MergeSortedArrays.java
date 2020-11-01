/*	
	Question: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	Problem: https://leetcode.com/problems/merge-sorted-array/

    Time Complexity: O(n+m) - two different array sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' elements
    Space Complexity: O(1) - consumption of memory is constant regardless of input - just iterating through existing array... not creating additional data structures to store memory
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;  
        int second = n - 1; 

        for (int i = nums1.length-1; i >= 0; i--) {  

            if (first < 0) {
                nums1[i] = nums2[second--]; 
            }
            else if (second < 0) { 
                nums1[i] = nums1[first--]; 
            }

            else {  
                if (nums1[first] > nums2[second]) {  
                    nums1[i] = nums1[first];  
                    first--;  
                }
                else { 
                    nums1[i] = nums2[second];  
                    second--;  
                }
            }
        }
    }
}