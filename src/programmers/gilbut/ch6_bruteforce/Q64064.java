package programmers.gilbut.ch6_bruteforce;

import java.util.*;

class Q64064 {

    static Set<Set<String>> total = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        Set<String> set = new HashSet<>();
        dfs(0,user_id,banned_id,visited,set);

        return total.size();
    }

    private void dfs(int depth, String[] user_id, String[] banned_id, boolean[] visited,Set<String> set){
        if(depth == banned_id.length){
            total.add(new HashSet<>(set));
            return;
        }

        String banned = banned_id[depth];

        for(int i=0;i<user_id.length;i++){
            if(!visited[i]){
                if(same(banned,user_id[i])){
                    visited[i] = true;
                    set.add(user_id[i]);
                    dfs(depth+1, user_id, banned_id, visited,set);
                    set.remove(user_id[i]);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean same(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        for(int c=0;c<str1.length();c++){
            if(str1.charAt(c)!='*'){
                if(str1.charAt(c)!=str2.charAt(c)){
                    return false;
                }
            }
        }
        return true;
    }
}