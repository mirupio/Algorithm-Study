package programmers.gilbut.ch11_datastructure;

import java.util.*;

// union-find + hashmap
class Q64063 {
    Map<Long,Long> parent = new HashMap<>();

    long find(long room){
        // 빈 방 발견
        if(!parent.containsKey(room)){
            parent.put(room,room+1);
            return room;
        }

        // 이미 찬 방 -> 다음 방 탐색
        long next = find(parent.get(room));
        // 경로 압축
        parent.put(room,next);
        return next;
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i=0;i<room_number.length;i++){
            answer[i] = find(room_number[i]);
        }

        return answer;
    }


}