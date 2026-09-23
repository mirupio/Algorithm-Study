package programmers.algorithm.string;

import java.util.*;

class Q468370 {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        String[] tokens = message.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String token: tokens){
            map.put(token,map.getOrDefault(token,0)+1);
        }

        Set<String> spoiler = new HashSet<>();
        int start = 0;

        // 스포방지 해제
        for(int i=0;i<=message.length();i++){
            if(i==message.length() || message.charAt(i)==' '){
                int end = i-1;
                String word = message.substring(start,i);

                for(int[] range: spoiler_ranges){
                    if(start<=range[1] && range[0]<=end){
                        map.put(word,map.get(word)-1);
                        break;
                    }
                }

                start = i+1;
            }
        }

        int total = 0;
        for(String str: map.keySet()){
            if(map.get(str) == 0){
                total++;
            }
        }

        return total;
    }
}