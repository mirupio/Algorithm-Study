package programmers.algorithm.twopointer;

import java.util.*;

class Q67258 {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int n = gems.length;

        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int type = set.size();

        Map<String,Integer> map = new HashMap<>();

        int left = 0;
        int answerLeft = 0;
        int answerRight = 0;
        int min = Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            // right 확장
            map.put(gems[right],
                    map.getOrDefault(gems[right],0)+1);

            // 모든 종류 포함하는 동안
            while(map.size() == type){
                int len = right-left+1;

                if(min > len){
                    min = len;
                    answerLeft = left;
                    answerRight = right;
                }

                // left 축소
                map.put(gems[left],
                        map.get(gems[left])-1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;
            }
        }

        return new int[]{answerLeft+1,answerRight+1};
    }
}