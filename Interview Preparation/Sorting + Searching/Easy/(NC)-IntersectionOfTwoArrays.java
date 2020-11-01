/*
	Question: Given two arrays, write a function to compute their intersection (common elements between both)
	Problem: https://leetcode.com/problems/intersection-of-two-arrays/
    
    Time Complexity: O(n+m) - two different array sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' elements
    Space Complexity: O(n+m) - consumption of memory scales linearly with input as we store up-to 'n' elements in HashSet... Worse case scenario all elements in both arrays are different
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) { 

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>(); 

        for (Integer num : nums1) { 
            set1.add(num); 
        }
        for (Integer num: nums2) {
            set2.add(num); 
        }

        set1.retainAll(set2); 

        int commonElements[] = new int[set1.size()];
        int x = 0; 

        for (int i: set1) { 
            commonElements[x++] = i;
        }
        //x++; // Can use this syntax or the one above to increment 'i' after every loop iteration

        return commonElements;
    }
}
