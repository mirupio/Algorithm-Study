package programmers.stackqueue;

import java.util.*;

// 큐 버전
class Q42586_2 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            int rest = 100 - progresses[i];
            int day = rest/speeds[i];
            if(rest%speeds[i]!=0){
                day++;
            }
            queue.add(day);
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int count = 1;

            while(!queue.isEmpty() && queue.peek() <= cur){
                queue.poll();
                count++;
            }
            result.add(count);
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i< result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}