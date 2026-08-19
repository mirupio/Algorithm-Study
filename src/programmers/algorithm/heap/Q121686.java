package programmers.algorithm.heap;

import java.util.*;

class Q121686 {
    public long[] solution(int[][] programs) {
        long[] answer = new long[11];

        int finTime = 0;

        // 아직 실행 대기열에 들어오지 않은 프로그램
        PriorityQueue<int[]> waitPq
                = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        // 현재 실행 가능한 프로그램
        PriorityQueue<int[]> runPq
                = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            else{
                return a[1]-b[1];
            }});

        for(int[] program: programs){
            waitPq.offer(program);
        }
        while(!waitPq.isEmpty() || !runPq.isEmpty()){

            // 실행할 프로그램이 없으면 다음 프로그램 호출 시간까지 이동
            if(runPq.isEmpty()){
                finTime = Math.max(finTime, waitPq.peek()[1]);
            }

            // 현재 시간까지 호출된 프로그램 전부 runPq에 넣기
            while(!waitPq.isEmpty() && waitPq.peek()[1] <= finTime){
                runPq.offer(waitPq.poll());
            }

            int[] cur = runPq.poll();
            int curA = cur[0];
            int curB = cur[1];
            int curC = cur[2];

            // 대기 시간
            answer[curA] += finTime-curB;

            // 실행
            finTime += curC;
        }

        answer[0] = finTime;
        return answer;
    }
}