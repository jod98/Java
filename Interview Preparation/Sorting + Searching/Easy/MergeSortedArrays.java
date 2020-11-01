/*	
	Question: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	Problem: https://leetcode.com/problems/merge-sorted-array/

    Time Complexity: O(n+m) - two different array sizes (n) and (m) so we add them in the time complexity. We iterate over 'n' and 'm' elements
    Space Complexity: O(1) - consumption of memory is constant regardless of input - just iterating through existing array... not creating additional data structures to store memory
    HELP: https://www.youtube.com/watch?v=zp4huR7LN6M&ab_channel=KeepOnCoding
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {  // sort nums1 array with merged nums2 array
        int first = m - 1;  // represents first index (pointer) we will check in array 1 (iterating backwards from index)
        int second = n - 1;  // represents first index (pointer) we will check in array 2 (iterating backwards from index)

        for (int i = nums1.length-1; i >= 0; i--) {  // start off at last index of 'nums1' i.e. 6 = length, 5 = last index

            if (first < 0) {  // if current index is less than 0 i.e. we have iterated over entire array1
                nums1[i] = nums2[second--];  // if first array is iterated then continuously add current element of second-- to array until both arrays are iterated over
            }
            else if (second < 0) {  // if current index is less than 0 i.e. we have iterated over entire array2
                nums1[i] = nums1[first--];  // if second array is iterated then continuously add current element of  first-- to array until both arrays are iterated over
            }

            else {  // Otherwise we still have to iterate over both arrays so..
                if (nums1[first] > nums2[second]) {  // if current array1 element > current array2 element...
                    nums1[i] = nums1[first];  // add current array1 element
                    first--;  // decrement it so it can retrieve the element before hand in the next iteration
                }
                else {  // else current array1 element < current array2 element...
                    nums1[i] = nums2[second];  // add current array2 element
                    second--;  // decrement it so it can retrieve the element before hand in the next iteration
                }
            }
        }
    }
}