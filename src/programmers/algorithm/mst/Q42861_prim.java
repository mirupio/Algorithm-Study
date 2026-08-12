package programmers.algorithm.mst;

import java.util.*;

class Q42861_prim {

    public int solution(int n, int[][] costs) {
        // 인접 리스트 생성
        List<int[]>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            graph[from].add(new int[]{to,cost});
            graph[to].add(new int[]{from,cost});
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        pq.offer(new int[]{0,0});

        int totalCost = 0;
        int count = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if(!visited[node]){
                visited[node] = true;
                totalCost += cost;
                count++;

                for(int[] next: graph[node]){
                    int nextNode = next[0];
                    int nextCost = next[1];

                    if(!visited[nextNode]){
                        pq.offer(new int[]{nextNode,nextCost});
                    }
                }
            }

            if(count == n){
                break;
            }
        }

        return totalCost;
    }
}