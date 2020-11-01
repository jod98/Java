/*
	Question: Determine maximum amount of money I can rob from a set of houses (array indexes representing house 1, house 2 etc. AND array values representing money stored at each house). NOTE: cannot rob houses beside each other (adjacent)
	Problem: https://leetcode.com/problems/house-robber/
    
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an array to store upto 'n' elements (max money robber can make)
*/

class Solution {
    public int rob(int[] nums) {  
        if (nums == null || nums.length == 0) {
            return 0;  
        }
        if (nums.length == 1)
        {
            return nums[0];  
        }

        int maxMoney[] = new int [nums.length]; 

        maxMoney[0] = nums[0];  
        maxMoney[1] = Math.max(nums[0], nums[1]);  

        for (int i=2; i<nums.length; i++) 
        {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[maxMoney.length - 1];  
    }
}