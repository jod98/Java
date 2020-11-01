/*
    Question: Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}. Build the target array using the following operations: Push: Read a new element from the beginning list, and push it in the array. Pop: delete the last element of the array. If the target array is already built, stop reading more elements. Return the operations to build the target array.
	Problem: https://leetcode.com/problems/build-an-array-with-stack-operations/
	
    Time Complexity: O(n) - where 'n' represents the size of the list we will have to (iterare through 'n' integers) to determine if current value appears in targer array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an arraylist to store up-to 'n' strings
*/

class Solution {
    public List<String> buildArray(int[] target, int n) { 
        ArrayList<String> arrayList = new ArrayList<String>();  
        int j = 0;  

        for(int i=1; i<=n && j<target.length; i++) {  /
            arrayList.add("Push");  

            if(target[j] == i) {  
                j++;  
            }
            else {  
                arrayList.add("Pop");
            }
        }
        return arrayList; 
    }
}
