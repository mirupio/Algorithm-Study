package programmers.algorithm.dfsbfs;

import java.util.*;

class Q468373 {
    class Edge{
        int to;
        int type;

        Edge(int to, int type){
            this.to = to;
            this.type = type;
        }
    }

    int n,k;
    int answer = 0;
    List<Edge>[] graph;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;
        this.k = k;

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            int type = edge[2];

            graph[from].add(new Edge(to,type));
            graph[to].add(new Edge(from,type)); // 양방향
        }

        boolean[] infected = new boolean[n+1];
        infected[infection] = true;

        dfs(0,infected);

        return answer;
    }

    // dfs : 어떤 종류의 파이프를 열지
    void dfs(int depth, boolean[] infected){
        answer = Math.max(answer, count(infected));

        if(depth == k){
            return;
        }

        for(int type=1; type<=3; type++){
            boolean[] next = infected.clone();

            spread(type,next);
            dfs(depth+1,next);
        }
    }

    // bfs : 그 파이프를 열었을 때 감염이 어디까지 퍼지는가
    void spread(int type, boolean[] infected){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            if(infected[i]){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Edge edge: graph[cur]){
                if(!infected[edge.to]
                        && edge.type == type){
                    infected[edge.to] = true;
                    q.offer(edge.to); // ⭐
                }
            }
        }
    }

    int count(boolean[] infected){
        int cnt = 0;

        for(int i=1;i<=n;i++){
            if(infected[i]) cnt++;
        }

        return cnt;
    }
}