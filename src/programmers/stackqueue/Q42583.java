package programmers.stackqueue;

import java.util.*;

class Q42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> b = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            b.add(0);
        }

        Queue<Integer> t = new LinkedList<>();
        for(int i:truck_weights){
            t.add(i);
        }

        int sum = 0;
        int sec = 0;
        while(!t.isEmpty()){
            int minus = b.poll();
            int plus = t.peek();
            sum = sum - minus + plus;

            if(sum > weight){
                sum -= plus;
                b.add(0);
            }
            else{
                b.add(plus);
                t.poll();
            }
            sec++;
        }

        int answer = sec+bridge_length;
        return answer;
    }
}