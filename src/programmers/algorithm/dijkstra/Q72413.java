package programmers.algorithm.dijkstra;

import java.util.*;

class Q72413 {
    static PriorityQueue<int[]> pq;
    static List<int[]>[] graph;
    static int[] distance;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] fare:fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph[from].add(new int[]{to,cost});
            graph[to].add(new int[]{from,cost});
        }

        int answer = Integer.MAX_VALUE;

        // S -> K + K -> A + K -> B
        // S -> K + A -> K + B -> K

        int[] disS = dijkstra(n,s); // S 시작
        int[] disA = dijkstra(n,a); // A 시작
        int[] disB = dijkstra(n,b); // B 시작

        for(int k=1;k<n+1;k++){
            answer = Math.min(answer,disS[k]+disA[k]+disB[k]);
        }

        return answer;
    }

    static int[] dijkstra(int n, int start){
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));

        distance[start] = 0;
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if(cost > distance[now]){
                continue;
            }

            for(int[] nexts : graph[now]){
                int next = nexts[0];
                int nextCost = nexts[1];

                if(distance[next] > distance[now] + nextCost){
                    distance[next] = distance[now] + nextCost;

                    pq.offer(new int[]{next,distance[next]});
                }
            }
        }
        return distance;
    }

}