package programmers.algorithm.heap;

import java.util.*;

class Q42628_2 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for(String s: operations){
            int num = Integer.parseInt(s.substring(2));
            if(s.charAt(0) == 'I'){
                pqMin.offer(num);
                pqMax.offer(num);
            }

            else{
                if(num == 1){
                    if(!pqMax.isEmpty()){
                        int max = pqMax.poll();
                        pqMin.remove(max);
                    }
                }
                else{
                    if(!pqMin.isEmpty()){
                        int min = pqMin.poll();
                        pqMax.remove(min);
                    }
                }
            }
        }

        if(pqMin.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }

        else{
            int max = pqMax.poll();
            answer[0] = max;

            int min = pqMin.poll();
            answer[1] = min;
        }

        return answer;
    }
}