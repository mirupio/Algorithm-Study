package programmers.algorithm.string;

import java.util.*;

class Q17677 {
    public int solution(String str1, String str2) {
        Map<String,Integer> str1MultiSet = makeMultiSet(str1);
        Map<String,Integer> str2MultiSet = makeMultiSet(str2);

        // 교집합 개수
        Set<String> set = new HashSet<>();
        for(String s:str1MultiSet.keySet()){
            set.add(s);
        }
        for(String s:str2MultiSet.keySet()){
            set.add(s);
        }

        int countG = 0;
        for(String s:set){
            int min = Math.min(str1MultiSet.getOrDefault(s,0),str2MultiSet.getOrDefault(s,0));
            countG += min;
        }

        // 합집합 개수
        int countH = 0;
        for(String s:set){
            int max = Math.max(str1MultiSet.getOrDefault(s,0),str2MultiSet.getOrDefault(s,0));
            countH += max;
        }

        double answer;
        if(countG == 0 && countH == 0){
            answer = 1;
        }
        else{
            answer = (double)countG/countH;
            // System.out.println("answer="+answer);
        }
        return (int)(answer * 65536);
    }

    static Map<String,Integer> makeMultiSet(String str){
        Map<String,Integer> multiSet = new HashMap<>();

        for(int i=0;i<str.length()-1;i++){
            String substr = str.substring(i,i+2);
            if(substr.matches("[a-zA-Z]+")){
                substr = substr.toLowerCase();
                multiSet.put(substr,multiSet.getOrDefault(substr,0)+1);
            }
        }

        return multiSet;
    }
}