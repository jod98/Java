/*
	Question: Given two arrays, write a function to compute their intersection (common elements between both). Each element in the result must be unique. The result can be in any order.
	Problem: https://leetcode.com/problems/intersection-of-two-arrays/
    
    Time Complexity: O(n+m) - two different array sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' elements
    Space Complexity: O(n+m) - consumption of memory scales linearly with input as we store up-to 'n' and 'm' elements in HashSets... Worse case scenario all elements in both arrays are different
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) { // Method that returns the common elements found betweenn two arrays

        HashSet<Integer> set1 = new HashSet<Integer>(); // Creating HashSet to store unique array1 (nums1) elements
        HashSet<Integer> set2 = new HashSet<Integer>(); // Creating HashSet to store unique array2 (nums2) elements

        for (Integer num : nums1) { // Iterating over all elements in array1
            set1.add(num); // Adding unique elements to set1 (not their duplicate)
        }
        for (Integer num: nums2) { // Iterating over all elements in array2
            set2.add(num); // Adding unique elements to set2 (not their duplicate)
        }

        set1.retainAll(set2); // set1 now only contains common elements between two arrays (.retainAll() just stores common elements)

        int commonElements[] = new int[set1.size()]; // Converting common elements set1 into array i.e. creating an array of size (set1)
        int x = 0; // Iterator

        for (int i: set1) { // Iterate over all elements in set1
            commonElements[x++] = i; // Storing set1 elements in array
        }
        //x++; // Can use this syntax or the one above to increment 'i' after every loop iteration

        return commonElements; // Returning array of common elements
    }
}
