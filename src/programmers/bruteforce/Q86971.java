package programmers.bruteforce;

import java.util.*;

class Q86971 {
    static boolean[] visited;
    static int count;
    static int min = Integer.MAX_VALUE;
    static List<List<Integer>> graph;
    public int solution(int n, int[][] wires) {
        // 인접행렬
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<wires.length;i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

        // 끊기
        for(int i=0;i<wires.length;i++){
            graph.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            graph.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));

            // dfs로 끊어진 트리 방문
            visited = new boolean[n+1];
            count = 0;
            dfs(1);

            // 차이
            int dif = Math.abs(count-(n-count));
            min = Math.min(dif,min);

            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

        return min;
    }

    static void dfs(int now){
        visited[now] = true;
        count++;
        for(int next : graph.get(now)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}