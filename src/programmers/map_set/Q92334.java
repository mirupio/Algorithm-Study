package programmers.map_set;

import java.util.*;

class Q92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고된 사람, 신고자
        Map<String, Set<String>> reports = new HashMap<>();
        for(int i=0;i<report.length;i++){
            String[] repo = report[i].split(" ");
            String u = repo[0]; // 신고자
            String r = repo[1]; // 신고된 사람

            Set<String> set = reports.getOrDefault(r,new HashSet<>());
            set.add(u);
            reports.put(r,set);
        }

        Map<String, Integer> results = new HashMap<>();
        // k 이상인 사람의 list에 있는 유저
        for(String str:reports.keySet()){
            int num = reports.get(str).size();
            if(num >= k){
                for(String users: reports.get(str)){
                    results.put(users,results.getOrDefault(users,0)+1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            answer[i] = results.getOrDefault(id_list[i],0);
        }

        return answer;
    }
}