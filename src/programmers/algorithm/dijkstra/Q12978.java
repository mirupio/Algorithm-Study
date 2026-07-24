package programmers.algorithm.dijkstra;

import java.util.*;

class Q12978 {
    static PriorityQueue<int[]> pq;
    static List<int[]>[] graph;
    static int[] distance;
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;
        int INF = 1000000000;

        // graph[i] = i번 마을과 연결된 도로들
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] road:roads){
            int from = road[0];
            int to = road[1];
            int cost = road[2];

            graph[from].add(new int[]{to,cost});
            graph[to].add(new int[]{from,cost});
        }

        // distance[i] = 1번 마을에서 i번 마을까지의 최단거리
        distance = new int[N+1];
        Arrays.fill(distance,INF);

        // {마을번호, 현재까지 거리}
        pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        distance[1] = 0;
        pq.offer(new int[]{1,0});

        dijkstra();

        for(int i=1;i<N+1;i++){
            if(distance[i] <= K){
                answer++;
            }
        }
        return answer;
    }

    static void dijkstra(){
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int nowDis = cur[1];

            // 이미 더 짧은 경로가 발견된 경우
            if(nowDis > distance[now]){
                continue;
            }

            for(int[] nexts: graph[now]){
                int next = nexts[0];
                int nextDis = nexts[1];

                int newDis = nowDis + nextDis;
                if(newDis < distance[next]){{
                    distance[next] = newDis;
                    pq.offer(new int[] {next,newDis});
                }}
            }
        }
    }
}