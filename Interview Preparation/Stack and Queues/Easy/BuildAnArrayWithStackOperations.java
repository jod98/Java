/*
    Question: Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}. Build the target array using the following operations: Push: Read a new element from the beginning list, and push it in the array. Pop: delete the last element of the array. If the target array is already built, stop reading more elements. Return the operations to build the target array.
	Problem: https://leetcode.com/problems/build-an-array-with-stack-operations/
	
    Time Complexity: O(n) - where 'n' represents the size of the list we will have to (iterare through 'n' integers) to determine if current value appears in targer array
    Space Complexity: O(n) - consumption of memory scales linearly with input as we initialise an arraylist to store up-to 'n' strings
    HELP: https://leetcode.com/problems/build-an-array-with-stack-operations/discuss/624040/I-don't-understand-the-question.-What-do-they-ask
*/

class Solution {
    public List<String> buildArray(int[] target, int n) {  // returning a list of strings that signifies if the current element in target needs to be "Pushed" or "Popped" based on list [1,2,3,4...n]
        ArrayList<String> arrayList = new ArrayList<String>();  // creating an arraylist of strings ("Push" and "Pop")
        int j = 0;  // iterates over all elements in target array

        for(int i=1; i<=n && j<target.length; i++) {  // iterate over both target array & list elements [1,2,3,4...n] and determine if element needs to be pushed or popped into target array to fit its input
            arrayList.add("Push");  // add "Push" to array list everytime and if current list value is in current target value then increment to next element in target... otherwise "Pop" the current element

            if(target[j] == i) {  // if list value is in target array...
                j++;  // we've found target element in list... so increment to retrieve next value in target array
            }
            else {  // otherwise... list value is not in target array...
                arrayList.add("Pop");  // remove the element from target array 'Pop'
            }
        }
        return arrayList;  // return the string of "Push" and "Pop" operations that allow us to create 'target' array
    }
}
