/*
	Question: Count the number of prime numbers less than a non-negative number, n.
	Problem: https://leetcode.com/problems/count-primes/
   
    Time Complexity: O(n^2) - nested for loop - we do 'n' amounts of work for 'n' elements i.e. n*n = n^2... where 'n' represents random integer value as input
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a boolean array to store up-to 'n' values where 'n' represents a random integer value
    HELP: https://www.youtube.com/watch?v=PypkiVlTRa4&ab_channel=TerribleWhiteboard
*/

public class Solution {
    public int countPrimes(int n) {  // return no. of prime numbers between 0 and 'n'

        boolean[] notPrime = new boolean[n];  // creating a boolean array of size 'n' with all values initialise to 'false'
        int count = 0;  // counts number of primes recorded between 0 and 'n'

        for (int i = 2; i < n; i++) {  // iterate through from 2 to 'n' because 0, 1 are definitely not prime numbers
            if (notPrime[i] == false) {  // if current element = false then the number is a prime considering it hasn't been eliminated by the nested loop
                count++;  // increment number of primes we found i.e. first loop iteration ('2') is a prime therefore incremented
                for (int j = 2; i*j < n; j++) {  // now we determine the multiple of each number from '2' to 'n-1' i.e. 2*3, 2*4... 3*2, 3*4 etc. and set their multiples to true i.e. not a prime num
                    notPrime[i*j] = true;  // setting multiples of element to true (not a prime)
                }
            }
        }
        return count;  // return number of prime numbers between 0 and 'n'
    }
}

