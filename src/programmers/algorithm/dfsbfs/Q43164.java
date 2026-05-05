package programmers.algorithm.dfsbfs;

import java.util.*;

class Q43164 {
    static Map<String,List<String>> graph = new TreeMap<>();
    static List<String> answer_list = new ArrayList<>();
    static int ticketCount;
    static boolean found = false;

    public String[] solution(String[][] tickets) {
        for(int i=0;i<tickets.length;i++){
            String a = tickets[i][0];
            String b = tickets[i][1];

            graph.putIfAbsent(a,new ArrayList<>());
            graph.get(a).add(b);
        }

        // 목적지 정렬
        for(List<String> list:graph.values()){
            Collections.sort(list);
        }

        ticketCount = tickets.length;
        answer_list.add("ICN");
        dfs("ICN",0);

        String[] answer = answer_list.toArray(new String[0]);
        return answer;
    }

    static void dfs(String now, int used){
        if(used == ticketCount){
            found = true;
            return;
        }

        if(!graph.containsKey(now)){
            return;
        }

        List<String> list = graph.get(now);
        for(int i=0;i<list.size();i++){
            String next = list.get(i);
            list.remove(i);
            answer_list.add(next);
            dfs(next,used+1);

            if(found){
                return;
            }

            answer_list.remove(answer_list.size()-1);
            list.add(i,next);
        }
    }
}
