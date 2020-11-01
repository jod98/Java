/*
    Question: You have a RecentCounter class which counts the number of recent requests within a certain time frame. 
	
	RecentCounter() - Initializes the counter with zero recent requests.
	int ping(int t) - Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
	
	Problem: https://leetcode.com/problems/number-of-recent-calls/
	
    Time Complexity: O(1) - time complexity for both insertion and deletion in queue data structure (3000 is a constant can never iterate more times than that - worse case scenario)
    Space Complexity: O(1) - consumption of memory remains constant irrespective of input as the maximal size of our sliding window is 3000, which is a constant.
    HELP: https://www.youtube.com/watch?v=NtNeA48tJDk&ab_channel=AnishMalla
*/

class RecentCounter {  // class that returns number of recent calls/ requests within 3000ms
    Queue<Integer> queue;  // declaring our queue data structure

    public RecentCounter() {  // general constructor
        queue = new LinkedList<Integer>();  // initialising our queue to be empty initially. A 'queue' in java is initialised through a linked list so have to use this syntax...
    }

    public int ping(int t) {  // method to add the current ping (time in milliseconds of request) to queue
        queue.add(t);  // adding current ping (count) to the queue

        while(queue.peek() < t - 3000) {  // if current queue element (i.e. previously added element - ping) (FIFO) doesn't fals in current range of 't' - 3000, 't'...
            queue.remove();  // then remove element from the queue
        }
        return queue.size();  // return size of queue i.e. count of how many pings fall in the range
    }
}
