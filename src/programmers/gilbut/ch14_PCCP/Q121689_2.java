package programmers.gilbut.ch14_PCCP;

import java.util.*;

// Queue로 풀기
class Q121689_2 {
    public int solution(int[] menu, int[] order, int k) {
        Queue<Integer> queue = new LinkedList<>();

        int max = 0;
        int endTime = 0;
        for(int i=0;i<order.length;i++){
            int arrivalTime = k*i;

            // 이미 음료 받은 손님은 카페에서 나감
            while(!queue.isEmpty() && queue.peek()<=arrivalTime){
                queue.poll();
            }

            // 현재 주문의 완성 시간 계산
            endTime = Math.max(endTime,arrivalTime) + menu[order[i]];

            // 이 손님의 퇴장 시간 저장
            queue.add(endTime);

            // 현재 카페 안 손님 수
            max = Math.max(max, queue.size());
        }

        return max;
    }
}