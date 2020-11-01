/*
	Question: Given two arrays, write a function to compute their intersection. Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.
	Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
    
    Time Complexity: O(n+m) - two different array sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' elements
    Space Complexity: O(n+m) - consumption of memory scales linearly with input as we store up-to 'n' and 'm' elements in the newly created array
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) { // Method that returns common elements betweenn two arrays (as many times as they appear)
        int commonElements[] = new int [nums1.length * nums2.length]; // Creating an array of common elements with max possible size
        int i = 0, j = 0, x = 0; // Creating our 3 iterators

        Arrays.sort(nums1); // Sorting array1 - allow us to compare element by element between arrays
        Arrays.sort(nums2); // Sorting array2 - allow us to compare element by element between arrays

        while (i < nums1.length && j < nums2.length) { // Iterating through elements in both arrays
            if (nums1[i] < nums2[j]) { // If array1 element < array2 element then increment array1 index (next element in sorted array)
                i++;
            }
            else if (nums1[i] > nums2[j]) { // If array1 element > array2 element then increment array2 index (next element in sorted array)
                j++;
            }
            else {
                // Insert element into array as this is a common element between both arrays
                // Both arrays have at least once instance of this common element
                commonElements[x++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(commonElements, 0, x); // Print common elements range of array (1,2,3) - not full size (1,2,3,0,0,0,0)
    }
}