/*
	Question: Count the number of prime numbers less than a non-negative number, n.
	Problem: https://leetcode.com/problems/count-primes/
   
    Time Complexity: O(n^2) - nested for loop - we do 'n' amounts of work for 'n' elements i.e. n*n = n^2... where 'n' represents random integer value as input
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a boolean array to store up-to 'n' values where 'n' represents a random integer value
*/

public class Solution {
    public int countPrimes(int n) {  

        boolean[] notPrime = new boolean[n];  
        int count = 0; 

        for (int i = 2; i < n; i++) {  
            if (notPrime[i] == false) { 
                count++;  
                for (int j = 2; i*j < n; j++) {  
                    notPrime[i*j] = true;  
                }
            }
        }
        return count;
    }
}

