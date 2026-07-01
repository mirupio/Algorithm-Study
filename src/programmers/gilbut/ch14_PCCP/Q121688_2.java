package programmers.gilbut.ch14_PCCP;

import java.util.*;

// 우선순위 큐
// : 우선순위가 가장 높은(또는 낮은) 원소를 가장 빨리 꺼낼 수 있는 자료구조
// 자바에서는 기본적으로 가장 작은 값이 먼저 나오는 최소 힙으로 구현
// 최대힙은 PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
class Q121688_2 {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int i=0;i<ability.length;i++){
            pq.add(ability[i]);
            sum += ability[i];
        }

        while(number-- > 0){
            int min = pq.poll();
            int min2 = pq.poll();
            int combined = min+min2;

            pq.add(combined);
            pq.add(combined);
            sum += combined;
        }

        return sum;
    }

}