/*
	Question: Return the first bad version of a product where the function 'isBadVersion' determines if current version of product is bad
	Problem: https://leetcode.com/problems/first-bad-version/
    
    Time Complexity: O(logn) - The search space is halved each time (log represents log base 2) - BINARY SEARCH
    Space Complexity: O(1) - consumption of memory is constant regardless of input - just iterating through existing array... not creating additional data structures to store memory
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); - ALREADY CREATED UNDER THE HOOD*/

public class Solution extends VersionControl {  
    public int firstBadVersion(int n) {  
        int left = 1;  
        int right = n; 

        while (left < right) {  
            int mid = left + (right - left) / 2; 
            if (!isBadVersion(mid)) {
                left = mid + 1 
            }
            else {
                right = mid;  
            }
        }
        return left; 
    }
}
        /* UNABLE TO DO THIS ITERATIVE METHOD INSTEAD BECAUSE IF WE HAVE '123414214124' AS INPUT IT WOULD TAKE A LONG TIME (TIME LIMIT EXCEEDED)
        for (int i = 1; i<n; i++) {
            if (isBadVersion(i) == true) {
                return i;
            }
        }
        */