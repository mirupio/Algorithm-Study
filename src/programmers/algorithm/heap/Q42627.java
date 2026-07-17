package programmers.algorithm.heap;

import java.util.*;

class Q42627 {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)-> {
                    int cmp = a[2]-b[2];
                    if(cmp!=0){
                        return cmp;
                    }
                    int cmp2 = a[1]-b[1];
                    if(cmp2!=0){
                        return cmp2;
                    }
                    return a[0]-b[0];
                });

        Arrays.sort(jobs,(a,b)->a[0]-b[0]);

        int sum = 0;
        int currentTime = 0;
        int index = 0;
        int completed = 0;

        while(completed < jobs.length){
            while(index<jobs.length
                    && jobs[index][0] <= currentTime){
                pq.offer(new int[]{index,jobs[index][0],jobs[index][1]});
                index++;
            }

            if(!pq.isEmpty()){

                int[] now = pq.poll();

                int requestTime = now[1];
                int duration = now[2];

                currentTime += duration;

                int returnTime = currentTime-requestTime;

                sum += returnTime;

                completed++;
            }

            else{
                currentTime = jobs[index][0];
            }

        }

        answer = sum/jobs.length;
        return answer;
    }
}