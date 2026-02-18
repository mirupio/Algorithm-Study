package programmers.stackqueue;

import java.util.*;

class Q42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 남은 작업량
        int[] rest = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            rest[i] = 100-progresses[i];
        }

        // 2. 작업 기간
        int[] day = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            day[i] = rest[i] / speeds[i];
            if(rest[i] % speeds[i] != 0){
                day[i] += 1;
            }
        }

        // 3. 기능 개수
        List<Integer> list = new ArrayList<>();
        int num = day[0];
        int count = 1;
        for(int i=1;i<day.length;i++){
            if(num >= day[i]){
                count++;
            }
            else{
                list.add(count);
                count = 1;
                num = day[i];
            }
        }
        if(count != 0){
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}