/*
	Question: Write a program that outputs the string representation of numbers from 1 to n. But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
	Problem: https://leetcode.com/problems/fizz-buzz/
    
    Time Complexity: O(n) - where 'n' represents the size of the input 'n' as we iterate through 'n' elements
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise an arraylist of strings to store up-to 'n' values where 'n' represents integer input value
*/

class Solution {
    public List<String> fizzBuzz(int n) {  
        List<String> list = new ArrayList<String>();  

        for(int i=1; i<n+1; i++) { 

            if(i % 3 == 0 && i % 5 == 0) { 
                list.add("FizzBuzz");
            }

            else if(i % 3 == 0){  
                list.add("Fizz");
            }

            else if(i % 5 == 0){  
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i)); 
            }
        }
        return list; 
    }
}