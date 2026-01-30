package programmers.hash;

import java.util.*;

class Q1845 {
    public int solution(int[] nums) {
        // (번호,개수) -> key 개수가 종류 개수
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        // 종류 개수 > 뽑는 개수 -> 뽑는 개수
        if(map.size() >= nums.length/2){
            return nums.length/2;
        }

        // 종류 개수 < 뽑는 개수 -> 종류 개수
        if(map.size() < nums.length/2){
            return map.size();
        }

        return -1;
    }
}