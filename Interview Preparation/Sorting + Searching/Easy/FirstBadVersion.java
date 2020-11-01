/*
	Question: Return the first bad version of a product where the function 'isBadVersion' determines if current version of product is bad
	Problem: https://leetcode.com/problems/first-bad-version/
    
    Time Complexity: O(logn) - The search space is halved each time (log represents log base 2) - BINARY SEARCH
    Space Complexity: O(1) - consumption of memory is constant regardless of input - just iterating through existing array... not creating additional data structures to store memory
    HELP: https://www.youtube.com/watch?v=SNDE-C86n88&ab_channel=KevinNaughtonJr.
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); - ALREADY CREATED UNDER THE HOOD*/

// We can use binary search because our dataset is sorted i.e. 'false', 'false'... 'true', 'true', 'true'
public class Solution extends VersionControl {  // accessing 'isBadVersion' function from parent class to determine first bad version of product
    public int firstBadVersion(int n) {  // returning first bad version of product i.e. first version that = true

        int left = 1;  // represents leftmost element of halving
        int right = n;  // represent rightmost element of halving

        while (left < right) {  // while left < right i.e. still possible to half the current dataset (at least 2 elements)
            int mid = left + (right - left) / 2; // used to prevent overflow... if right = Integer.MAX_VALUE then '(left + right) / 2' would throw an error
            if (!isBadVersion(mid)) {
                left = mid + 1 // leftmost element now set to midpoint + 1 - ('left + (right - left) / 2') i.e. ('1 + (6 - 1) / 2') = 3.5 but truncated = 3 (i.e. covered midpoint already)
            }
            else {
                right = mid;  // rightmost element now set to midpoint - ('left + (right - left) / 2') i.e. ('1 + (6 - 1) / 2') = 3.5 but truncated = 3 (i.e. haven't covered midpoint already so we include it)
            }
        }
        return left; // return leftmost element considering 'right' is now midpoint... 'left' = first 'true' (badVersion) product
    }
}
        /* UNABLE TO DO THIS ITERATIVE METHOD INSTEAD BECAUSE IF WE HAVE '123414214124' AS INPUT IT WOULD TAKE A LONG TIME (TIME LIMIT EXCEEDED)
        for (int i = 1; i<n; i++) {
            if (isBadVersion(i) == true) {
                return i;
            }
        }
        */