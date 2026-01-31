package programmers.dfsbfs;

import java.util.*;

class Q43163 {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int[] distance = new int[words.length];
        return bfs(begin,target,words,visited,distance);
    }

    static int bfs(String now,String target,String[] words,boolean[] visited,int[] distance){
        Queue<String> queue = new LinkedList<>();
        queue.add(now);
        Map<String,Integer> word = new HashMap<>();
        for(int i=0;i<words.length;i++){
            word.put(words[i],i);
        }

        while(!queue.isEmpty()){
            String cur = queue.poll();
            int dis;
            if(cur.equals(now)){
                dis = 0;
            }
            else{
                int index = word.get(cur);
                dis = distance[index];
            }

            // words 안에 있는 단어 중
            // 현재 단어와 한글자만 다른 것
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<words.length;i++){
                String s = words[i];
                if (OneDifferent(s,cur)){
                    map.put(s,i);
                }
            }

            if(cur.equals(target)){
                return dis;
            }
            for(String s:map.keySet()){
                if(!visited[map.get(s)]){
                    visited[map.get(s)] = true;
                    distance[map.get(s)] = dis + 1;
                    queue.add(s);
                }
            }
        }

        return 0;
    }

    // 한글자만 다른지
    static boolean OneDifferent(String a,String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        else{
            return false;
        }
    }
}