/*
	Question: Determine maximum amount of money I can rob from a set of houses (array indexes representing house 1, house 2 etc. AND array values representing money stored at each house). NOTE: cannot rob houses beside each other (adjacent)
	Problem: https://leetcode.com/problems/house-robber/
    
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an array to store upto 'n' elements (max money robber can make)
    HELP: https://www.youtube.com/watch?v=iGkRO_lgHzg&ab_channel=TerribleWhiteboard
*/

// Dynamic Programming (Memoisation) - caching results of function calls so we don't need to recompute
class Solution {
    public int rob(int[] nums) {   // method to return the max amount of money that can be robbed from a set of houses (not side by side)
        if (nums == null || nums.length == 0) {
            return 0;  // if there are 0 houses, return 0
        }
        if (nums.length == 1)
        {
            return nums[0];  // if there are 1 houses, return 1 (can only rob from one house)
        }

        int maxMoney[] = new int [nums.length];  // store max amount of money the robber can make

        maxMoney[0] = nums[0];  // setting value of 1st maxMoney element to nums (house money) element
        maxMoney[1] = Math.max(nums[0], nums[1]);  // storing the max value between 1st and 2nd house into 2nd element of maxMoney array... defined as i-2 is out of bends in below algorithm if we don't define this element

        for (int i=2; i<nums.length; i++)  // iterate through houses (money) array from 3rd element (we've found largest of first 2)
        {
            // determine the greater value:
            //    - previous element on it own
            //    - previous previous element + current element of house array
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[maxMoney.length - 1];  // return last element in maxMoney array... maxMoney we can make from robbing the provided set of houses i.e. nums -> [8,1,3,10,7] = maxArray -> [8,8,11,18,18]. '18' = '8 + 10' (1st + 4th house)... houses not side by side therefore possible

    }
}