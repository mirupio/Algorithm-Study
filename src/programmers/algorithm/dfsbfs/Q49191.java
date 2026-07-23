package programmers.algorithm.dfsbfs;

import java.util.*;

class Q49191 {
    static boolean[] visited;
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<Integer>[] win = new ArrayList[n+1];
        List<Integer>[] lose = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        for(int[] result: results){
            int winner = result[0];
            int loser = result[1];

            win[winner].add(loser);
            lose[loser].add(winner);
        }

        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            int down = dfs(i,win);

            visited = new boolean[n+1];
            int up = dfs(i,lose);

            if(down+up == n-1){
                answer++;
            }
        }

        return answer;
    }

    static int dfs(int now, List<Integer>[] graph){
        visited[now] = true;

        int count = 0;

        for(int next: graph[now]){
            if(!visited[next]){
                count++;
                count += dfs(next,graph);
            }
        }

        return count;
    }

}