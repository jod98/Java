/*
	Question: Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
	Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
	
    Time Complexity: O(2n) -> O(n) (drop constants) - where 'n' represents the size/no.of chars in String 's' as we iterate over all them in 2 separate for loops
    Space Complexity: O(n) - allocating memory to initialise a hashmap of worst case scenario 'n' possible entries where 'n' represents size of String 's'... memory consumption scales linearly with input
*/

class Solution {
    public int firstUniqChar(String s) {  
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();  

        for (int i=0; i<s.length(); i++) {  
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);   
        }
        //System.out.println(Arrays.asList(map));  // if we want to print the map

        for (int i=0; i<s.length(); i++) {  
            if (map.get(s.charAt(i)) == 1) {  
                return i;  
            }
        }
        return -1; 
    }
}