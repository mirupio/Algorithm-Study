package programmers.algorithm.heap;

import java.util.*;

class Q42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : scoville){
            pq.offer(i);
        }

        // 최소값이 K 이상이 될 때까지
        int min = pq.peek();
        int count = 0;
        while(min<K){
            if(pq.size()>=2){
                count++;
                int min1 = pq.poll();
                int min2 = pq.poll();
                int upSco = min1 + min2*2;
                pq.offer(upSco);
            }

            else{
                return -1;
            }
            min = pq.peek();
        }


        return count;
    }
}