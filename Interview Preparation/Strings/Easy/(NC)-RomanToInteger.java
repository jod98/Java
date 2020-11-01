/*
	Question: Given a roman numeral, convert it to an integer.
	Problem: https://leetcode.com/problems/roman-to-integer/
	
    Time Complexity: O(n) - where 'n' represents the size of the string as we iterare through 'n' characters
    Space Complexity: O(n) - consumption of memory scales linearly with input as we simply initialise a hashmap to store up-to 'n' key/value pairs where 'n' represents number of chars in String 's'
*/

class Solution {
    public int romanToInt(String s) {

        if (s == null || s.length() == 0) { 
            return -1;
        }

        HashMap<Character,Integer> romanNum = new HashMap<Character,Integer>(); 
        romanNum.put('I', 1);
        romanNum.put('V', 5);
        romanNum.put('X', 10);
        romanNum.put('L', 50);
        romanNum.put('C', 100);
        romanNum.put('D', 500);
        romanNum.put('M', 1000);

        int len = s.length(); 
        int result = romanNum.get(s.charAt(len - 1)); 

        for (int i = len-2; i >= 0; i--) {

            if (romanNum.get(s.charAt(i)) >= romanNum.get(s.charAt(i + 1))) { 
                result += romanNum.get(s.charAt(i)); 
            }
            else {
                result -= romanNum.get(s.charAt(i));
            }
        }
        return result; 
    }
}