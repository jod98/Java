/*
	Question: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
	Problem: https://leetcode.com/problems/pascals-triangle/

    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over each index for each row i.e. 'element*rows'
    Space Complexity: O(n^2) - consumption of memory scales linearly with input as we need to store each number we update in triangle
    HELP: https://www.youtube.com/watch?v=icoql2WKmbA&ab_channel=NickWhite
*/

class Solution {
    public List<List<Integer>> generate(int numRows) { // Method to return list of list of integers i.e. Paschal's Triangle

        List<List<Integer>> triangle = new ArrayList<>(); // Creating an ArrayList (holds list of integers inside that make up triangle)

        if (numRows == 0) { // If numRows passed in = 0, then return empty ArrayList
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>(); // Creating an ArrayList of integers that will hold values
        firstRow.add(1); // Add '1' in first row of list
        triangle.add(firstRow); // Add this then to triangle ArrayList (outputted ArrayList)

        for (int i=1; i<numRows; i++) { // Iterating rows in triangle and populating indexes (start at 1st index because we have 0th index)
            List<Integer> prevRow = triangle.get(i-1); // Get previous row in triangle
            List<Integer> currRow = new ArrayList<>(); // Get current row in triangle
            currRow.add(1); // Add '1' to first index of current row

            for(int j=1; j<i; j++) { // Iterating through each element in each row and populating it
                currRow.add(prevRow.get(j-1) + prevRow.get(j)); // New element = sum of previous two elements above it (prevRow)
            }
            currRow.add(1); // Add '1' to last index of current row
            triangle.add(currRow); // Add each row (list) to the outer triangle list each time so we can output it
        }
        return triangle; // Return outer triangle - ArrayList (integers) of an ArrayList (integers)
    }
}


