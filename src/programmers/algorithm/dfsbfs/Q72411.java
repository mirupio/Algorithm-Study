package programmers.algorithm.dfsbfs;

import java.util.*;

class Q72411 {
    static int O,C;
    static String order;
    static Map<String,Integer> map;
    public String[] solution(String[] orders, int[] courses) {

        List<String> answers = new ArrayList<>();
        for(int c: courses){
            map = new HashMap<>();
            for(String o: orders){
                O = o.length();
                C = c;
                order = o;
                dfs(0,"");
            }

            /*
            for(Map.Entry<String,Integer> entry: map.entrySet()){
                System.out.println("key="+entry.getKey()+" value="+entry.getValue());
            }
            */

            // map에서 값이 큰 애들 꺼내기
            int maxValue = 2;
            List<String> maxKeys = new ArrayList<>();
            for(Map.Entry<String,Integer> entry: map.entrySet()){
                if(entry.getValue() > maxValue){
                    maxValue = entry.getValue();

                    maxKeys.clear();
                    maxKeys.add(entry.getKey());
                }
                else if(entry.getValue() == maxValue){
                    maxKeys.add(entry.getKey());
                }
            }
            for(String s: maxKeys){
                answers.add(s);
            }
            /*
            for(String s:answers){
                System.out.print(s+" ");
            }
            System.out.println();
            */
        }

        String[] answer = new String[answers.size()];
        for(int i=0;i<answers.size();i++){
            answer[i] = answers.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    static void dfs(int index, String str){
        // 마지막 인덱스까지 도달
        // course 수만큼 문자열 모아지면 map에 put
        if(index == O){
            if(str.length() == C){
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                str = new String(arr);
                map.put(str,map.getOrDefault(str,0)+1);
            }
            return;
        }

        // 현재 인덱스 넣거나 빼거나
        dfs(index+1,str+order.charAt(index));
        dfs(index+1,str);
    }
}