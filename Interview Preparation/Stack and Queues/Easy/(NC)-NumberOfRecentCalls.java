/*
    Question: You have a RecentCounter class which counts the number of recent requests within a certain time frame. 
	
	RecentCounter() - Initializes the counter with zero recent requests.
	int ping(int t) - Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
	
	Problem: https://leetcode.com/problems/number-of-recent-calls/
	
    Time Complexity: O(1) - time complexity for both insertion and deletion in queue data structure (3000 is a constant can never iterate more times than that - worse case scenario)
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as the maximal size of our sliding window is 3000, which is a constant.
*/

class RecentCounter { 
    Queue<Integer> queue; 

    public RecentCounter() {  
        queue = new LinkedList<Integer>();  
    }

    public int ping(int t) {  
        queue.add(t);

        while(queue.peek() < t - 3000) { 
            queue.remove();
        }
        return queue.size(); 
    }
}
