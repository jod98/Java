/*
	Question: Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
	Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
	
    Time Complexity: O(2n) -> O(n) (drop constants) - where 'n' represents the size/no.of chars in String 's' as we iterate over all them in 2 separate for loops
    Space Complexity: O(n) - allocating memory to initialise a hashmap of worst case scenario 'n' possible entries where 'n' represents size of String 's'... memory consumption scales linearly with input
*/

class Solution {
    public int firstUniqChar(String s) {  // return the first unique character in String 's'
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();  // hashmap will store key/value (char, int) pairs so that when we locate a character we know how many times it appears in 's'

        for (int i=0; i<s.length(); i++) {  // iterate through all characters in the string
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);   // place current character and number of times it appears (i.e. if it appears... integer value = 1)
        }
        //System.out.println(Arrays.asList(map));  // if we want to print the map

        for (int i=0; i<s.length(); i++) {  // iterate through all characters in the string
            if (map.get(s.charAt(i)) == 1) {  // hashmap lookup determines how many times the current character appears in the string... if the value=1 (appears ONLY once).. then that is first unique char
                return i;  // return first unique character
            }
        }
        return -1;  // else if string doesn't contain a unique character this return statement will be triggered and we will return '-1'
    }
}