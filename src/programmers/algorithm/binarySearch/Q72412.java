package programmers.algorithm.binarySearch;

import java.util.*;

class Q72412 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // map
        // key: string 조건
        // value: 점수 조건
        Map<String,List<Integer>> map = new HashMap<>();
        for(String s:info){
            String[] tokens = s.split(" ");
            // "java backend junior pizza 150"
            // java,backend,junior,pizza,150
            String[] languages = {tokens[0],"-"};
            String[] jobs = {tokens[1],"-"};
            String[] careers = {tokens[2],"-"};
            String[] foods = {tokens[3],"-"};
            for(String l:languages){
                for(String j:jobs){
                    for(String c:careers){
                        for(String f:foods){
                            String key = l+j+c+f;

                            int score = Integer.parseInt(tokens[4]);
                            if(!map.containsKey(key)){
                                map.put(key,new ArrayList<>());
                            }
                            map.get(key).add(score);
                        }
                    }
                }
            }

        }

        // 정렬
        for(String s:map.keySet()){
            Collections.sort(map.get(s));
        }

        // 탐색
        for(int j=0;j<query.length;j++){
            String[] tokens = query[j].split(" ");
            // "java and backend and junior and pizza 100"
            // java,and,backend,and,junior,and,pizza,100
            String str
                    = tokens[0]+tokens[2]+tokens[4]+tokens[6];
            int num = Integer.parseInt(tokens[7]);
            List<Integer> range
                    = map.getOrDefault(str,new ArrayList<>());
            int idx = binarySearch(range,num);
            answer[j] = range.size()-idx;
        }

        return answer;
    }

    // lower bound = target 이상인 첫번째 위치
    static int binarySearch(List<Integer> list,
                            int target){
        int left = 0;
        int right = list.size();
        while(left<right){
            int mid = (left+right)/2;

            if(list.get(mid)<target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}