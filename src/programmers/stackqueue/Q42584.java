package programmers.stackqueue;

import java.util.*;

public class Q42584 {
    public static void main(String[] args) {
        programmers.stackqueue.Solution sol = new programmers.stackqueue.Solution();
        int[] prices = {1, 2, 3, 2, 3};

        int[] result = sol.solution(prices);
        System.out.println(result);
    }
}

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i:prices){
            q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            int sec = 0;

            /*System.out.println("now = " + now);
            System.out.println("sec = " + sec);

            for(int i:q){
                System.out.print(i +" ");
            }
            System.out.println();*/

            for(int next:q){
                sec++;
                if(now>next){
                    break;
                }
            }
            list.add(sec);
        }

        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}