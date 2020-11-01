/*
	Question: Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle. Notice that the row index starts from 0.
	Problem: https://leetcode.com/problems/pascals-triangle-ii/
	
    Time Complexity: O(n^2) - where 'n' represents size of input array... we iterate over each index for each row i.e. 'element*rows'
    Space Complexity: O(n^2) - consumption of memory scales linearly with input as we need to store each number we update in triangle
*/

class Solution {
    public List<Integer> getRow(int rowIndex) { 

        List<List<Integer>> triangle = new ArrayList<>(); 
        List<Integer> firstRow = new ArrayList<>(); 
        firstRow.add(1); 
        triangle.add(firstRow); 

        for (int i=1; i<=rowIndex; i++) { 
            List<Integer> prevRow = triangle.get(i-1); 
            List<Integer> currRow = new ArrayList<>(); 
            currRow.add(1); 

            for(int j=1; j<i; j++) { 
                currRow.add(prevRow.get(j-1) + prevRow.get(j)); 
            }
            currRow.add(1); 
            triangle.add(currRow); 
        }
        return triangle.get(rowIndex); 
    }
}

