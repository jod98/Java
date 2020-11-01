/*
	Question: Find maximum profit that can be made from buying and selling stocks on certain days where input array index represents days and the value represents stock price. ONLY 1 TRANSACTION i.e. buy one stock and sell again
	Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
    HELP: https://www.youtube.com/watch?v=3RHCb8LY-X4&ab_channel=NickWhite
*/

class Solution {
    public int maxProfit(int[] prices) { // Method that returns max profit we can make from buy and sell stock (only buy and sell once)
        int maxProfit = 0; // Store max profit for stock buy and sell

        for (int i = 0; i < prices.length-1; i++) { // Iterating through array
            for (int j = i + 1; j < prices.length; j++) { // Iterating through array
                int currProfit = prices[j] - prices[i]; // Find current profit -> next day - current day etc.

                if(currProfit > maxProfit) { // If our current profit > max profit received so far...
                    maxProfit = currProfit;
                }
            }
        }
        return maxProfit; // Return max profit that can be made from buying and selling stock
    }
}

/*
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE; // Set to (+2147483648) to avoid issues when supplied different arguments
        int maxProfit = 0; // Store max profit for stock buy and sell

        for (int i=0; i<prices.length; i++) { // Iterating through elements in array (stock prices and corresponding day)
            if (prices[i] < minValue) {
                minValue = prices[i]; // Finding minimum value in array
            }
            else if (prices[i] - minValue > maxProfit) { // If current element - minimum value > max profit then...
                maxProfit = prices[i] - minValue; // Set max profit as current element - minimum element
            }
        }
        return maxProfit; // Return max profit that can be made from buying and selling stock
    }
}

