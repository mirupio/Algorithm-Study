package programmers.algorithm.implementation;

import java.util.*;

class Q258711 {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        Map<Integer,Integer> in = new HashMap<>();
        Map<Integer,Integer> out = new HashMap<>();
        for(int[] edge: edges){
            out.put(edge[0],out.getOrDefault(edge[0],0)+1);
            in.put(edge[1],in.getOrDefault(edge[1],0)+1);
        }

        // 시작점: 진출만 2개 이상
        for(int i: out.keySet()){
            if(out.get(i) >= 2 && in.getOrDefault(i, 0) == 0 ){
                answer[0] = i;
                break;
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == answer[0]) {
                int next = edge[1];
                in.put(next, in.get(next) - 1);
            }
        }


        for(int i: in.keySet()){
            // 막대: 진출0
            if(out.getOrDefault(i,0)==0){
                answer[2]++;
            }

            // 8자: 진입2, 진출2
            else if(in.get(i)==2 && out.getOrDefault(i,0)==2 ){
                answer[3]++;
            }
        }

        // 도넛: 전체에서 빼기
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}