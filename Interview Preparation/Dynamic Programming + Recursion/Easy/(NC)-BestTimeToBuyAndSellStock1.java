/*
	Question: Find maximum profit that can be made from buying and selling stocks on certain days where input array index represents days and the value represents stock price. ONLY 1 TRANSACTION i.e. buy one stock and sell again
	Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int maxProfit(int[] prices) { 
        int maxProfit = 0; 

        for (int i = 0; i < prices.length-1; i++) { 
            for (int j = i + 1; j < prices.length; j++) { 
                int currProfit = prices[j] - prices[i]; 

                if(currProfit > maxProfit) { 
                    maxProfit = currProfit;
                }
            }
        }
        return maxProfit; 
    }
}

/*
    Time Complexity: O(n) - where 'n' represents number of element in input array... we iterate over entire array
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as we simply create variables to store values
*/

class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE; 
        int maxProfit = 0; 

        for (int i=0; i<prices.length; i++) { 
            if (prices[i] < minValue) {
                minValue = prices[i]; 
            }
            else if (prices[i] - minValue > maxProfit) { 
                maxProfit = prices[i] - minValue; 
            }
        }
        return maxProfit; 
    }
}

