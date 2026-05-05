package programmers.algorithm.hash;

import java.util.*;

class Q42576_2 {
    public String solution(String[] participant, String[] completion) {

        // participant로 해시맵에 개수 저장
        Map<String,Integer> map = new HashMap<>();
        for(String s:participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        // completion에 있으면 해시맵에서 개수 감소
        for(String s:completion){
            map.put(s,map.get(s)-1);
        }

        // 해시맵에서 개수 0이상인 것 출력
        for(String s:map.keySet()){
            if(map.get(s)>0){
                return s;
            }
        }

        return "";
    }
}
