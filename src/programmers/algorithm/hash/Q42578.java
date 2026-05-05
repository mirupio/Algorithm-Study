package programmers.algorithm.hash;

import java.util.*;

class Q42578 {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }

        // n개의 의상 중 하나를 입거나 안입거나 -> n+1 경우의수
        // n+1 * ... -1(다 안입었을 때)
        int count = 1;
        for(String s:map.keySet()){
            count *= map.get(s)+1;
        }

        return count-1;
    }
}
