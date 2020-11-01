/*
	Question: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
	Problem: https://leetcode.com/problems/pascals-triangle/

    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over each index for each row i.e. 'element*rows'
    Space Complexity: O(n^2) - consumption of memory scales linearly with input as we need to store each number we update in triangle
*/

class Solution {
    public List<List<Integer>> generate(int numRows) { 

        List<List<Integer>> triangle = new ArrayList<>(); 
        if (numRows == 0) { 
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>(); 
        firstRow.add(1);
        triangle.add(firstRow); 

        for (int i=1; i<numRows; i++) { 
            List<Integer> prevRow = triangle.get(i-1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1); 

            for(int j=1; j<i; j++) { 
                currRow.add(prevRow.get(j-1) + prevRow.get(j)); 
            }
            currRow.add(1); 
            triangle.add(currRow); 
        }
        return triangle; 
    }
}


