/*
	Question: Given a roman numeral, convert it to an integer.
	Problem: https://leetcode.com/problems/roman-to-integer/
	
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterare through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashmap to store up-to 'n' key/value pairs where 'n' represents number of chars in String 's'
*/

class Solution {
    public int romanToInt(String s) {

        if (s == null || s.length() == 0) { // If 's' is not a valid string, return -1
            return -1;
        }

        HashMap<Character,Integer> romanNum = new HashMap<Character,Integer>(); // Create a HashMap to store chars and ints (key, value)
        romanNum.put('I', 1); // Adding key and value into HashMap. When requested 'key', we return 'value'
        romanNum.put('V', 5);
        romanNum.put('X', 10);
        romanNum.put('L', 50);
        romanNum.put('C', 100);
        romanNum.put('D', 500);
        romanNum.put('M', 1000);

        int len = s.length(); // Store length of string
        int result = romanNum.get(s.charAt(len - 1)); // Storing value of last character (roman numeral) in string

        // Iterating backwards to determine if prev element > curr element
        // If... it is then we we add the numeral's values else... 'I', 'X' or 'C' in front so we have to subtract
        for (int i = len-2; i >= 0; i--) {

            if (romanNum.get(s.charAt(i)) >= romanNum.get(s.charAt(i + 1))) { // If prev > curr element
                result += romanNum.get(s.charAt(i)); // Adding all numerals together (correct descending order)
            }
            else {
                result -= romanNum.get(s.charAt(i)); // Subtract prev element from current element i.e. 'IX' = X(5) - I(1) = 4
            }
        }
        return result; // Return the roman numeral value
    }
}