package programmers.gilbut.ch11_datastructure;

import java.util.*;

// 메모리 초과
class Q60060 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            for(int i=0;i<word.length();i++){
                String str = word.substring(0,i+1)+String.valueOf(word.length()-i-1);
                map.put(str,map.getOrDefault(str,0)+1);

                str = String.valueOf(word.length()-i-1)+word.substring(word.length()-i-1);
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }

        for(int i=0;i<queries.length;i++){
            String query = queries[i];

            int start = query.indexOf('?');
            int end = query.lastIndexOf('?');
            int length = end-start+1;

            String queryStr = "";
            // 접두사일 경우
            if(start == 0){
                queryStr = String.valueOf(length)+query.substring(end+1);
            }

            // 접미사일 경우
            else if(end == query.length()-1){
                queryStr = query.substring(0,start)+String.valueOf(length);
            }

            answer[i] = map.getOrDefault(queryStr,0);
        }

        return answer;
    }
}