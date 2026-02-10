package programmers.bruteforce;

import java.util.*;

class Q42839 {
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        String num = "";
        set = new HashSet<>();
        dfs(num,numbers);

        return set.size();
    }

    static void dfs(String num, String numbers){
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                String next = num + numbers.charAt(i);
                int next_num = Integer.parseInt(next);
                if(isPrime(next_num)){
                    set.add(next_num);
                }
                visited[i] = true;
                dfs(next,numbers);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int n){
        if(n<2){
            return false;
        }

        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}