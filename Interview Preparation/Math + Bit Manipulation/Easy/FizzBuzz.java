/*
	Question: Write a program that outputs the string representation of numbers from 1 to n. But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
	Problem: https://leetcode.com/problems/fizz-buzz/
    
    Time Complexity: O(n) - where 'n' represents the size of the input 'n' as we iterate through 'n' elements
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise an arraylist of strings to store up-to 'n' values where 'n' represents integer input value
*/

class Solution {
    public List<String> fizzBuzz(int n) {  // return a string list (arraylist) holding particular values
        List<String> list = new ArrayList<String>();  // creating arraylist to hold string values

        for(int i=1; i<n+1; i++) {  // iterating through elements of arraylist from '1 - n' and inserting correct values based on below conditions

            if(i % 3 == 0 && i % 5 == 0) {  // if 'i' is divisible by both '3' and '5' then add 'FizzBuzz'
                list.add("FizzBuzz");
            }

            else if(i % 3 == 0){  // if 'i' is divisible by '3' then add 'Fizz'
                list.add("Fizz");
            }

            else if(i % 5 == 0){  // if 'i' is divisible by '5' then add 'Buzz'
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i)); // otherwise add current index value to the arraylist.. 'i' starts at '1' as this is the first element to be inserted into arraylist not '0'
            }
        }
        return list;  // return new arraylist
    }
}