package programmers.algorithm.stackqueue;

import java.util.*;

class Q155651 {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        Arrays.sort(book_time,(a,b)
                ->changeToMinute(a[0])-changeToMinute(b[0]));
        for(String[] time : book_time){
            int startTime = changeToMinute(time[0]);
            int endTime = changeToMinute(time[1])+10;

            while(!pq.isEmpty() && pq.peek() <= startTime){
                pq.poll();
            }

            pq.add(endTime);
            max = Math.max(max,pq.size());
        }

        return max;
    }

    static int changeToMinute(String s){
        return Integer.parseInt(s.substring(0,2))*60
                + Integer.parseInt(s.substring(3,5));
    }
}