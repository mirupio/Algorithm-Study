package programmers.algorithm.stackqueue;

import java.util.*;

class Q176962 {
    public String[] solution(String[][] plans) {
        Stack<String[]> stack = new Stack<>(); // [과제명, 남은 시간]
        List<String> answer = new ArrayList<>(); // 정답

        Arrays.sort(plans,(a,b)
                -> changeToMinute(a[1])-changeToMinute(b[1]));

        String currentName = plans[0][0];
        int currentStart = changeToMinute(plans[0][1]);
        int currentPlayTime = Integer.parseInt(plans[0][2]);
        for(int i=1;i<plans.length;i++){
            int nextStart = changeToMinute(plans[i][1]);
            int currentEnd = currentStart + currentPlayTime;

            // 다음 과제가 시작돼서 현재 과제를 끝내지 못함
            if(currentEnd > nextStart){
                int remainTime = currentEnd - nextStart;
                stack.push(new String[]{currentName,String.valueOf(remainTime)});
            }
            else{
                // 현재 과제 끝냄
                answer.add(currentName);

                int freeTime = nextStart - currentEnd;

                while(!stack.isEmpty() && freeTime>0){
                    String[] paused = stack.pop();

                    String pausedName = paused[0];
                    int pausedTime = Integer.parseInt(paused[1]);

                    // 멈춘 과제를 다 못 끝냄
                    if(pausedTime > freeTime){
                        stack.push(new String[] {
                                pausedName,
                                String.valueOf(pausedTime-freeTime)
                        });
                        freeTime = 0;
                    }
                    // 멈춘 과제를 끝냄
                    else{
                        answer.add(pausedName);
                        freeTime -= pausedTime;
                    }
                }
            }

            // 다음 과제 -> 현재 과제로 갱신
            currentName = plans[i][0];
            currentStart = nextStart;
            currentPlayTime = Integer.parseInt(plans[i][2]);
        }

        // 마지막 과제 완료
        answer.add(plans[plans.length - 1][0]);

        // 멈췄던 과제들을 최근 것부터 완료
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        return answer.toArray(new String[0]);
    }

    static int changeToMinute(String s){
        return Integer.parseInt(s.substring(0,2))*60
                +Integer.parseInt(s.substring(3,5));
    }
}